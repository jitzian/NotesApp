package com.test.challenge.toyotaapp.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.test.challenge.toyotaapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    displayBackButton: Boolean = false,
) = TopAppBar(
    modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp),
    navigationIcon = {
        when {
            displayBackButton -> Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.back_TEXT),
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
                    .clickable { onClick?.invoke() },
            )

            else -> Unit
        }
    },
    title = {
        Text(
            modifier = modifier.padding(start = 16.dp),
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.headlineMedium
        )
    }
)