package com.test.challenge.toyotaapp.data.domain.mappers

import com.test.challenge.toyotaapp.data.db.entities.TaskEntityDB
import com.test.challenge.toyotaapp.data.domain.model.TaskDTO
import javax.inject.Inject

class TaskDtoToTaskEntityDBMapper @Inject constructor() : (TaskDTO) -> TaskEntityDB {
    override fun invoke(input: TaskDTO) = with(input) {
        TaskEntityDB(title = title, content = content)
    }
}