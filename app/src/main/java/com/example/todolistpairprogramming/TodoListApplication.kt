package com.example.todolistpairprogramming

import android.app.Application

class TodoListApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}