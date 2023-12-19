package com.example.todolistpairprogramming.repository

import com.example.todolistpairprogramming.model.Task

interface ITaskRepository {
    fun getIncompleteTasks(): List<Task>
    fun getCompleteTasks(): List<Task>
}