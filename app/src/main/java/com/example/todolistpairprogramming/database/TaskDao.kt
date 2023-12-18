package com.example.todolistpairprogramming.database

import androidx.room.Dao
import androidx.room.Query
import com.example.todolistpairprogramming.model.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getAll(): List<Task>
}