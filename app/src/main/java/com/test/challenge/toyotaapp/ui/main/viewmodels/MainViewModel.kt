package com.test.challenge.toyotaapp.ui.main.viewmodels

import androidx.lifecycle.ViewModel
import com.test.challenge.toyotaapp.data.domain.model.TaskDTO
import com.test.challenge.toyotaapp.ui.main.MainUIState
import com.test.challenge.toyotaapp.ui.main.usecases.GetAllTasksUseCase
import com.test.challenge.toyotaapp.ui.main.usecases.SaveTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllTasksUseCase: GetAllTasksUseCase,
    private val saveTaskUseCase: SaveTaskUseCase
) : ViewModel() {
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val _state: MutableStateFlow<MainUIState> = MutableStateFlow(MainUIState.Empty)
    val state = _state.asStateFlow()

    init {
        getAllTasks()
    }

    private fun getAllTasks() = scope.launch {
        getAllTasksUseCase.getAllTasks().collect {
            _state.emit(it)
        }
    }

    override fun onCleared() = super.onCleared().also { scope.coroutineContext.cancel() }

    fun addTask(title: String, content: String) = scope.launch {
        _state.update { MainUIState.Loading }
        delay(1.seconds)
        saveTaskUseCase.addTask(TaskDTO(title = title, content = content))
    }

}