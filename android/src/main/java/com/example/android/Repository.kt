package com.example.android

import android.content.Context
import org.hisp.dhis.android.core.D2
import org.hisp.dhis.android.core.D2Configuration
import org.hisp.dhis.android.core.D2Manager
import org.hisp.dhis.android.core.D2Manager.blockingInstantiateD2
import org.hisp.dhis.android.core.trackedentity.TrackedEntityAttributeValue
import org.hisp.dhis.android.core.trackedentity.TrackedEntityInstance

class Repository(context: Context) {

    private val d2: D2 = instantiateD2(context)

    private fun instantiateD2(context: Context): D2 {
        if (!D2Manager.isD2Instantiated()) {
            blockingInstantiateD2(
               D2Configuration.builder()
                   .context(context)
                   .connectTimeoutInSeconds(5000)
                   .readTimeoutInSeconds(5000)
                   .build()
           )
        }
        return D2Manager.getD2()
    }

    fun login() {
        if (!d2.userModule().isLogged().blockingGet()) {
            d2.userModule().blockingLogIn("admin", "district", "https://debug.dhis2.org/2.40dev/")
        }
    }

    fun getProgram() = d2.programModule().programs().uid(PROGRAM_UID).blockingGet()

    fun getAssistanceDataElement() =
        d2.dataElementModule().dataElements().byUid().eq(DATAELEMENT_UID).blockingGet()

    fun getTeiByProgram() =
        d2.trackedEntityModule().trackedEntityInstances().byProgramUids(listOf(PROGRAM_UID))
            .withTrackedEntityAttributeValues().blockingGet()

    fun getTrackedEntityAttributeValues(tei: TrackedEntityInstance): List<TrackedEntityAttributeValue> {
        val attributes = getProgramTrackedEntityAttributes().mapNotNull {
            it.trackedEntityAttribute()?.uid() to it
        }.toMap()

        return attributes.mapNotNull {
            getTrackedEntityAttributeValue(tei.uid(), it.key)
        }
    }

    private fun getTrackedEntityAttributeValue(
        trackedEntityInstanceUid: String,
        trackedEntityAttributeUid: String?,
    ): TrackedEntityAttributeValue? {
        return d2.trackedEntityModule().trackedEntityAttributeValues()
            .byTrackedEntityInstance().eq(trackedEntityInstanceUid)
            .byTrackedEntityAttribute().eq(trackedEntityAttributeUid)
            .one()
            .blockingGet()
    }

    private fun getProgramTrackedEntityAttributes() =
        d2.programModule().programTrackedEntityAttributes().byProgram().eq(PROGRAM_UID).blockingGet()

}


const val PROGRAM_UID = "PqbAI6WeFzE"
const val DATAELEMENT_UID = "YwOO2MKNtPL"