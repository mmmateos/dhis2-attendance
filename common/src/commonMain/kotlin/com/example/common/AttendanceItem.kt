package com.example.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import com.example.common.model.StudentModel
import org.hisp.dhis.mobile.ui.designsystem.component.CheckBox
import org.hisp.dhis.mobile.ui.designsystem.component.CheckBoxData
import org.hisp.dhis.mobile.ui.designsystem.theme.Spacing
import org.hisp.dhis.mobile.ui.designsystem.theme.SurfaceColor
import org.hisp.dhis.mobile.ui.designsystem.theme.TextColor

@Composable
fun StudentItem(
    attendanceItem: StudentModel,
    onChecked: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            attendanceItem.firstName.first().toString(),
            style = MaterialTheme.typography.labelLarge,
            color = TextColor.OnPrimary,
            modifier = Modifier
                .padding(Spacing.Spacing24)
                .drawBehind {
                    drawCircle(
                        color = SurfaceColor.Primary,
                        radius = this.size.maxDimension,
                    )
                }
            ,
        )
        Column {
            Text(
                attendanceItem.firstName,
                style = MaterialTheme.typography.titleSmall,
                color = TextColor.OnSurface,
                modifier = Modifier.padding(top = Spacing.Spacing8),
            )
            Text(
                attendanceItem.lastName,
                style = MaterialTheme.typography.labelMedium,
                color = TextColor.OnSurface.copy(alpha = 0.7f),
                modifier = Modifier.padding(top = Spacing.Spacing4),
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        CheckBox(
            modifier = Modifier.padding(Spacing.Spacing16),
            checkBoxData = CheckBoxData(
                uid = "",
                checked = attendanceItem.attend,
                enabled = true,
                textInput = null,
            ),
            onCheckedChange = onChecked,
        )
    }
}
