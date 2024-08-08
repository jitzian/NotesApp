package com.test.challenge.toyotaapp.ui.main.usecases

import android.util.Log
import com.test.challenge.toyotaapp.data.domain.mappers.TaskToTaskDtoMapper
import com.test.challenge.toyotaapp.data.domain.repository.TaskRepository
import com.test.challenge.toyotaapp.ui.main.MainUIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GetAllTasksUseCase @Inject constructor(
    private val taskRepository: TaskRepository,
    private val mapper: TaskToTaskDtoMapper,
) {
    private val TAG = "GetAllTasksUseCase"

    /*fun getAllTasks() = taskRepository.getAllTasks().map { tasks ->
        tasks.map { mapper.invoke(it) }
    }*/

    suspend fun getAllTasks0(): MainUIState = runCatching {

        /*taskRepository.getAllTasks().map { tasks ->
            tasks.map { mapper.invoke(it) }
        }.collectLatest {  }*/

        taskRepository.getAllTasks().map { tasks ->
            tasks.map { mapper.invoke(it) }
        }.collectLatest {
            Log.e(TAG, "getAllTasks::Success -> $it")
            MainUIState.Success(it)
        }

    }.getOrElse {
        Log.e(TAG, "getAllTasks::${it.message}")
        MainUIState.Error(it.message ?: "An error occurred")
    } as MainUIState

    fun getAllTasks_(): Flow<MainUIState> {
        return taskRepository.getAllTasks()
            .map { tasks ->
                val taskDTOs = tasks.map { mapper.invoke(it) }
                MainUIState.Success(taskDTOs) as MainUIState
            }
            .onStart { emit(MainUIState.Loading) }
            .catch { exception ->
                Log.e(TAG, "getAllTasks::${exception.message}")
                emit(MainUIState.Error(exception.message ?: "An error occurred"))
            }
    }

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