package com.test.challenge.toyotaapp.ui.main.usecases

import com.test.challenge.toyotaapp.data.domain.mappers.TaskDtoToTaskEntityDBMapper
import com.test.challenge.toyotaapp.data.domain.model.TaskDTO
import com.test.challenge.toyotaapp.data.domain.repository.TaskRepository
import javax.inject.Inject

class SaveTaskUseCase @Inject constructor(
    private val mapper: TaskDtoToTaskEntityDBMapper,
    private val taskRepository: TaskRepository,
) {
    suspend fun addTask(task: TaskDTO) = taskRepository.addTask(mapper.invoke(task))
}