package com.example.todolistpairprogramming.repository

import com.example.todolistpairprogramming.database.TaskDao
import com.example.todolistpairprogramming.model.Task

class TaskRepository(private val taskDao: TaskDao) : ITaskRepository {
    override fun getAllTasks(): List<Task> = taskDao.getAll()
}