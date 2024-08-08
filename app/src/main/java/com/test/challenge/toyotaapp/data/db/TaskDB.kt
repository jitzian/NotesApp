package com.test.challenge.toyotaapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.test.challenge.toyotaapp.data.db.dao.TaskDao
import com.test.challenge.toyotaapp.data.db.entities.TaskEntityDB
import com.test.challenge.toyotaapp.constants.GlobalConstants

@Database(
    entities = [
        TaskEntityDB::class
    ],
    version = GlobalConstants.DB_VERSION,
    exportSchema = false,
)
abstract class TaskDB : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        /* The value of a volatile variable will never be cached and all writes and reads will de done to and from the main memory.
        * This helps to make sure that the value of INSTANCE is always up-to-date and the same for all execution threads.
        * It means that changes made by one thread to INSTANCE are visible to all other threads immediately*/
        @Volatile
        private var INSTANCE: TaskDB? = null

        fun getInstance(context: Context): TaskDB {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDB::class.java,
                        GlobalConstants.DB_NAME
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}