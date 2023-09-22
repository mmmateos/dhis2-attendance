package com.example.common

import androidx.compose.runtime.Composable
import org.hisp.dhis.mobile.ui.designsystem.theme.DHIS2Theme

@Composable
fun App() {
    DHIS2Theme {
        val students = getStudents()
        AttendanceScreen(
            students
        ) {

        }
    }
}


