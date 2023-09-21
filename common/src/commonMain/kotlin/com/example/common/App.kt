package com.example.common

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.common.model.StudentModel
import org.hisp.dhis.mobile.ui.designsystem.theme.DHIS2Theme

@Composable
fun App() {
    val student = StudentModel("Manu", "Muñoz", true)
    val students = listOf(student, student, student, student, student)
    DHIS2Theme {
        AttendanceScreen(
            students
        ) {

        }
    }
}


