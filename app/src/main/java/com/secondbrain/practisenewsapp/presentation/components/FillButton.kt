package com.secondbrain.practisenewsapp.presentation.components

import android.opengl.Visibility
import android.view.View
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.secondbrain.practisenewsapp.presentation.Dimens

@Composable
fun FillButton(
    text: String,
    isPrimary: Boolean,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isPrimary) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.background
            },
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ), shape = RoundedCornerShape(size = Dimens.roundedShapeDimen)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
        )
    }
}