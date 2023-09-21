package com.example.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.common.model.AttendanceTei
import org.hisp.dhis.mobile.ui.designsystem.theme.Spacing
import org.hisp.dhis.mobile.ui.designsystem.theme.SurfaceColor
import org.hisp.dhis.mobile.ui.designsystem.theme.TextColor

@Composable
fun AttendanceItem(attendanceItem: AttendanceTei) {
    Row {
        Text(
            attendanceItem.firstName.first().toString(),
            style = MaterialTheme.typography.labelLarge,
            color = TextColor.OnPrimary,
            modifier = Modifier
                .background(SurfaceColor.Primary, CircleShape)
                .padding(Spacing.Spacing10),
        )
        Text(
            attendanceItem.firstName + attendanceItem.lastName,
            style = MaterialTheme.typography.titleLarge,
            color = TextColor.OnSurface,
            modifier = Modifier.padding(Spacing.Spacing10),
        )
    }
}

