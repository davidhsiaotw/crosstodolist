package com.example.todolistpairprogramming.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Task(
    @PrimaryKey val id: Long,
    val name: String,
    val note: String = "",
    val date: String,
    val location: String = "",
    val isComplete: Boolean = false
) : Parcelable
