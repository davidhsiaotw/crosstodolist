package com.example.todolistpairprogramming.repository

import androidx.lifecycle.LiveData
import com.example.todolistpairprogramming.model.Task

interface ITaskRepository {
    fun getIncompleteTasks(): LiveData<List<Task>>
    fun getCompleteTasks(): LiveData<List<Task>>
    suspend fun addTask(task: Task)
    suspend fun updateTask(task: Task)
}