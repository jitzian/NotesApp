package com.test.challenge.toyotaapp.data.domain.mappers

import com.test.challenge.toyotaapp.data.db.entities.TaskEntityDB
import com.test.challenge.toyotaapp.data.domain.model.TaskDTO
import javax.inject.Inject

class TaskToTaskDtoMapper @Inject constructor() : (TaskEntityDB) -> TaskDTO {
    override fun invoke(input: TaskEntityDB) = with(input) {
        TaskDTO(id = id, title = title ?: "", content = content ?: "")
    }
}