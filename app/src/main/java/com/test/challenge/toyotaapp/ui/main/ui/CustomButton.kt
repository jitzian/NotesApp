package com.test.challenge.toyotaapp.ui.main.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    label: String,
    isEnabled: Boolean,
) = Button(
    onClick = onClick,
    modifier = modifier,
    enabled = isEnabled,
) { Text(text = label) }