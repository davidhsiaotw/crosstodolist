package com.example.todolistpairprogramming.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.todolistpairprogramming.TodoListApplication
import com.example.todolistpairprogramming.repository.ITaskRepository

class TaskViewModel(private val taskRepository: ITaskRepository) : ViewModel() {

    var number = MutableLiveData(1)

    fun test() {
        number.value = number.value?.plus(1)
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