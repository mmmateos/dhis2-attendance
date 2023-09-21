package com.example.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.common.model.StudentModel
import org.hisp.dhis.mobile.ui.designsystem.theme.Spacing
import org.hisp.dhis.mobile.ui.designsystem.theme.SurfaceColor
import org.hisp.dhis.mobile.ui.designsystem.theme.TextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceScreen(
    students: List<StudentModel>,
    onAttendanceClicked: (StudentModel) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(
                    text = "Attendance",
                    color = TextColor.OnPrimary,
                    modifier = Modifier.padding(start = Spacing.Spacing8),
                    ) },
                navigationIcon = { Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.padding(start = Spacing.Spacing8),
                ) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = SurfaceColor.Primary,
                    titleContentColor = TextColor.OnPrimary,
                    navigationIconContentColor = TextColor.OnPrimary)
            )
        }
    )
    {
        Column(Modifier.padding(it).fillMaxHeight()) {
            Text(
                modifier = Modifier.padding(vertical = Spacing.Spacing8, horizontal = Spacing.Spacing16),
                text = "6th grade, A",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                modifier = Modifier.padding(start = Spacing.Spacing16),
                text = "Friday, Sep. 21, 2023",
                style = MaterialTheme.typography.titleMedium
            )
            LazyColumn(Modifier.padding(top = Spacing.Spacing8)) {
                items(students) { student ->
                    StudentItem(student) {
                        onAttendanceClicked.invoke(student.copy(attend = it))
                    }
                }
            }
        }
    }
}