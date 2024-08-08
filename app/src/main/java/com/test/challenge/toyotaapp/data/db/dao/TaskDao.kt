package com.test.challenge.toyotaapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.test.challenge.toyotaapp.data.db.entities.TaskEntityDB
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: TaskEntityDB)

    @Query("SELECT * FROM task WHERE id = :id")
    fun findByTaskId(id: Int): TaskEntityDB

    @Query("SELECT * FROM task")
    fun getAllTasks(): Flow<List<TaskEntityDB>>

    @Update
    suspend fun updateTask(task: TaskEntityDB)

    @Delete
    suspend fun deleteTask(task: TaskEntityDB)

}