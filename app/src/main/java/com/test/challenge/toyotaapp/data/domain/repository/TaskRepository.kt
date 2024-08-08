package com.test.challenge.toyotaapp.data.domain.repository

import com.test.challenge.toyotaapp.data.db.entities.TaskEntityDB
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun addTask(task: TaskEntityDB)
    fun findByTaskId(id: Int): TaskEntityDB
    fun getAllTasks(): Flow<List<TaskEntityDB>>
    suspend fun updateTask(task: TaskEntityDB)
    suspend fun deleteTask(task: TaskEntityDB)
}