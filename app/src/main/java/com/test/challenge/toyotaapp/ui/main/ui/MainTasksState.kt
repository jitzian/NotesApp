package com.test.challenge.toyotaapp.ui.main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.test.challenge.toyotaapp.R
import com.test.challenge.toyotaapp.ui.common.LoadingScreen
import com.test.challenge.toyotaapp.ui.main.MainUIState
import com.test.challenge.toyotaapp.ui.main.viewmodels.MainViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTasksState(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()
    var showBottomSheet by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    when (state) {
        MainUIState.Loading -> LoadingScreen()
        MainUIState.Empty -> EmptyScreen()
        is MainUIState.Error -> Unit
        is MainUIState.Success -> MainTasksStateScreen(
            modifier = modifier.fillMaxWidth(),
            data = state as MainUIState.Success
        )
    }

    Box(modifier = modifier.fillMaxSize()) {
        FloatingActionButton(
            onClick = { showBottomSheet = true },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            content = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.add_task_TEXT)
                )
            }
        )
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = bottomSheetState
        ) {
            BottomSheetContentBuilder(
                modifier = modifier,
                onSave = { title, content ->
                    viewModel.addTask(title = title, content = content)
                    scope.launch { bottomSheetState.hide() }
                    showBottomSheet = false
                }
            )
        }
    }

}
