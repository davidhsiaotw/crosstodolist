package com.example.todolistpairprogramming.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todolistpairprogramming.model.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM task WHERE isComplete = 0")
    fun getInCompleteTasks(): List<Task>

    @Query("SELECT * FROM task WHERE isComplete = 1")
    fun getCompleteTasks(): List<Task>

    @Insert
    fun addTask(task: Task)

    @Update
    fun updateTask(task: Task)
}