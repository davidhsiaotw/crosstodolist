package com.example.todolistpairprogramming

import android.content.Context
import com.example.todolistpairprogramming.database.AppDatabase
import com.example.todolistpairprogramming.repository.TaskRepository

/**
 * Container of objects shared across the whole app
 *
 * [manual dependency injection](https://developer.android.com/training/dependency-injection/manual#dependencies-container)
 */
class AppContainer(context: Context) {
    val taskDatabase = AppDatabase.getDatabase(context)
    val taskRepository = TaskRepository(taskDatabase.taskDao())
}