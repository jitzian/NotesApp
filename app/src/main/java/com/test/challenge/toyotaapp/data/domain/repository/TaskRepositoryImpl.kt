package com.test.challenge.toyotaapp.data.domain.repository

import android.app.Application
import com.test.challenge.toyotaapp.data.db.TaskDB
import com.test.challenge.toyotaapp.data.db.dao.TaskDao
import com.test.challenge.toyotaapp.data.db.entities.TaskEntityDB
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    context: Application,
) : TaskRepository {

    private val db = TaskDB.getInstance(context)
    private var taskDao: TaskDao = db.taskDao()

    override suspend fun addTask(task: TaskEntityDB) = taskDao.addTask(task)
    override fun findByTaskId(id: Int) = taskDao.findByTaskId(id)
    override fun getAllTasks() = taskDao.getAllTasks()
    override suspend fun updateTask(task: TaskEntityDB) = taskDao.updateTask(task)
    override suspend fun deleteTask(task: TaskEntityDB) = taskDao.deleteTask(task)
}