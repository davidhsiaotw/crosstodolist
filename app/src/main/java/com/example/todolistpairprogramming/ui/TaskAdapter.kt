package com.example.todolistpairprogramming.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todolistpairprogramming.R
import com.example.todolistpairprogramming.model.Task

class TaskAdapter(private val tasks: List<Task>, private val onClickListener: () -> Unit) :
    ListAdapter<Task, ViewHolder>(TASK_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return TaskViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false),
            onClickListener
        )
    }

    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as TaskViewHolder).bind(tasks[position])
    }

    companion object {
        val TASK_COMPARATOR = object : DiffUtil.ItemCallback<Task>() {
            override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem == newItem
            }

        }
    }
}