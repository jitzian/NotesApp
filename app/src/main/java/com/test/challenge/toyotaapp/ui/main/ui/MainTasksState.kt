package com.test.challenge.toyotaapp.ui.main.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.test.challenge.toyotaapp.ui.common.LoadingScreen
import com.test.challenge.toyotaapp.ui.main.MainUIState
import com.test.challenge.toyotaapp.ui.main.viewmodels.MainViewModel

@Composable
fun MainTasksState(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()

    when (state) {
        MainUIState.Loading -> LoadingScreen()
        MainUIState.Empty -> EmptyScreen()
        is MainUIState.Error -> Unit
        is MainUIState.Success -> MainTasksStateScreen(
            modifier = modifier.fillMaxWidth(),
            data = state as MainUIState.Success
        )
    }


}
