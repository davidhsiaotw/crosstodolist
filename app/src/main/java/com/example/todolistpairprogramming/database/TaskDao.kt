package com.example.todolistpairprogramming.database

import androidx.room.Dao
import androidx.room.Query
import com.example.todolistpairprogramming.model.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM task WHERE isComplete = 0")
    fun getInCompleteTasks(): List<Task>

    @Query("SELECT * FROM task WHERE isComplete = 1")
    fun getCompleteTasks(): List<Task>
}