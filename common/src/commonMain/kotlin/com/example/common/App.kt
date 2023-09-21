package com.example.common

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.common.model.AttendanceTei
import org.hisp.dhis.mobile.ui.designsystem.theme.DHIS2Theme

@Composable
fun App() {
    DHIS2Theme {
        LazyColumn {
            items(8) {
                AttendanceItem(
                    AttendanceTei(
                        firstName = "Manu",
                        lastName = "Muñoz",
                        attend = false,
                    ),
                )
            }
        }
    }
}
