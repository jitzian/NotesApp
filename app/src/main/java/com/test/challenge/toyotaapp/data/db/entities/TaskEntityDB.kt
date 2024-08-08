package com.test.challenge.toyotaapp.data.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "task")
data class TaskEntityDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String? = "",
    val content: String? = "",
) : Parcelable