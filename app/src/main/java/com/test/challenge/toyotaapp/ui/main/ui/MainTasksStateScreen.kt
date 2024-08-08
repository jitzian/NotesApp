package com.test.challenge.toyotaapp.ui.main.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.test.challenge.toyotaapp.ui.main.MainUIState

@Composable
fun MainTasksStateScreen(
    modifier: Modifier = Modifier,
    data: MainUIState.Success
) = LazyColumn(modifier = modifier.fillMaxWidth()) {
    items(data.data) { TaskRowItem(data = it) }
}