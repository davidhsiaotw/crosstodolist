package com.example.todolistpairprogramming.repository

import com.example.todolistpairprogramming.model.Task

interface ITaskRepository {
    fun getAllTasks(): List<Task>
}