package com.example.todolistpairprogramming.ui

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todolistpairprogramming.R
import com.example.todolistpairprogramming.model.Task

class TaskViewHolder(
    view: View, private val onClickListener: (Task) -> Unit,
    private val onClickCheckboxListener: (Task) -> Unit
) : ViewHolder(view) {
    private val checkBox: CheckBox = view.findViewById(R.id.checkBox)
    private val name: TextView = view.findViewById(R.id.item_task_name)
    private val note: TextView = view.findViewById(R.id.item_task_note)
    private val date: TextView = view.findViewById(R.id.item_task_date)
    private val location: TextView = view.findViewById(R.id.item_task_location)

    private var task: Task? = null

    init {
        view.setOnClickListener { task?.let { t -> onClickListener(t) } }
    }

    fun bind(task: Task) {
        this.task = task
        checkBox.isChecked = task.isComplete
        checkBox.setOnClickListener {
            onClickCheckboxListener(task.copy(isComplete = !task.isComplete))
        }
        name.text = task.name
        note.text = task.note
        date.text = task.date
        location.text = task.location
    }
}