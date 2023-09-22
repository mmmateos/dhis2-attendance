package com.example.common.repository

import okhttp3.Request
import org.hisp.dhis.android.core.D2
import org.hisp.dhis.android.core.D2Configuration
import org.hisp.dhis.android.core.D2Manager
import org.hisp.dhis.android.core.D2Manager.blockingInstantiateD2
import org.hisp.dhis.android.core.trackedentity.TrackedEntityAttributeValue
import org.hisp.dhis.android.core.trackedentity.TrackedEntityInstance
import retrofit2.Call

class Repository() {

    private val d2: D2 = getD2Instance()

    private fun getD2Instance() = D2Manager.getD2()

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