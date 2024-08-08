package com.test.challenge.toyotaapp.ui.main.viewmodels

import androidx.lifecycle.ViewModel
import com.test.challenge.toyotaapp.ui.main.MainUIState
import com.test.challenge.toyotaapp.ui.main.usecases.GetAllTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainViewModel"

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllTasksUseCase: GetAllTasksUseCase,
) : ViewModel() {
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val _state: MutableStateFlow<MainUIState> = MutableStateFlow(MainUIState.Empty)
    val state = _state.asStateFlow()

    init {
        getAllTasks()
    }

    private fun getAllTasks() = scope.launch {
        getAllTasksUseCase.getAllTasks().collectLatest{ _state.update { it } }
    }

    override fun onCleared() = super.onCleared().also { scope.coroutineContext.cancel() }

}