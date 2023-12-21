package com.example.todolistpairprogramming.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todolistpairprogramming.model.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM task WHERE isComplete = 0")
    fun getInCompleteTasks(): LiveData<List<Task>>

    @Query("SELECT * FROM task WHERE isComplete = 1")
    fun getCompleteTasks(): LiveData<List<Task>>

    @Insert
    suspend fun addTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)
}