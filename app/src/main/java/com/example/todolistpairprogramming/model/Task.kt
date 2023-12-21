package com.example.todolistpairprogramming.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    val name: String = "New task",
    val note: String = "",
    val date: String,
    val location: String = "",
    val isComplete: Boolean = false
) : Parcelable
