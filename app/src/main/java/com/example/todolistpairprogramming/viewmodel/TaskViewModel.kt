package com.example.todolistpairprogramming.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.todolistpairprogramming.TodoListApplication
import com.example.todolistpairprogramming.model.Task
import com.example.todolistpairprogramming.repository.ITaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(private val taskRepository: ITaskRepository) : ViewModel() {
    private var _incompleteTasks = taskRepository.getIncompleteTasks()
    val incompleteTasks: LiveData<List<Task>> = _incompleteTasks

    private var _completeTasks = taskRepository.getCompleteTasks()
    val completeTasks: LiveData<List<Task>> = _completeTasks

    fun addTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            taskRepository.addTask(task)
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            taskRepository.updateTask(task)
        }
    }

    // https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-factories
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as TodoListApplication)
                TaskViewModel(application.container.taskRepository)
            }
        }
    }
}