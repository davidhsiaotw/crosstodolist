package com.example.todolistpairprogramming.repository

import androidx.lifecycle.LiveData
import com.example.todolistpairprogramming.database.TaskDao
import com.example.todolistpairprogramming.model.Task

class TaskRepository(private val taskDao: TaskDao) : ITaskRepository {
    override fun getIncompleteTasks(): LiveData<List<Task>> = taskDao.getInCompleteTasks()
    override fun getCompleteTasks(): LiveData<List<Task>> = taskDao.getCompleteTasks()
    override suspend fun addTask(task: Task) = taskDao.addTask(task)
    override suspend fun updateTask(task: Task) = taskDao.updateTask(task)
}