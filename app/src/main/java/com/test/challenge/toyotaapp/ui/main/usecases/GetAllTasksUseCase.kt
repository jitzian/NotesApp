package com.test.challenge.toyotaapp.ui.main.usecases

import android.util.Log
import com.test.challenge.toyotaapp.data.domain.mappers.TaskToTaskDtoMapper
import com.test.challenge.toyotaapp.data.domain.repository.TaskRepository
import com.test.challenge.toyotaapp.ui.main.MainUIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GetAllTasksUseCase @Inject constructor(
    private val taskRepository: TaskRepository,
    private val mapper: TaskToTaskDtoMapper,
) {
    private val TAG = "GetAllTasksUseCase"
    fun getAllTasks(): Flow<MainUIState> = flow {
        runCatching {
            taskRepository.getAllTasks()
                .map { tasks ->
                    val taskDTOs = tasks.map { mapper.invoke(it) }
                    when {
                        taskDTOs.isEmpty() -> MainUIState.Empty
                        else -> MainUIState.Success(taskDTOs)
                    }
                }
                .onStart { emit(MainUIState.Loading) }
                .catch { exception ->
                    Log.e(TAG, "getAllTasks::${exception.message}")
                    emit(MainUIState.Error(exception.message ?: "An error occurred"))
                }
                .collect { emit(it) }
        }.onFailure { exception ->
            Log.e(TAG, "getAllTasks::${exception.message}")
            emit(MainUIState.Error(exception.message ?: "An error occurred"))
        }
    }
}