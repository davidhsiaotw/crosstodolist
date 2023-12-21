package com.example.todolistpairprogramming.ui.edit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todolistpairprogramming.databinding.FragmentTaskBinding
import com.example.todolistpairprogramming.model.Task
import com.example.todolistpairprogramming.viewmodel.TaskViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class TaskFragment : Fragment() {
    private val taskViewModel: TaskViewModel by activityViewModels { TaskViewModel.Factory }
    private var _binding: FragmentTaskBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs: TaskFragmentArgs by navArgs()
        bind(safeArgs.task)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun bind(task: Task?) {
        _binding?.let {
            it.buttonSaveTask.setOnClickListener { _ ->
                if (task == null) {
                    taskViewModel.addTask(
                        Task(
                            name = it.textInputTaskName.editText?.text.toString(),
                            note = it.textInputTaskNote.editText?.text.toString(),
                            date = it.textInputTaskDate.editText?.text.toString(),
                            location = it.textInputTaskLocation.editText?.text.toString(),
                        )
                    )
                } else {
                    taskViewModel.updateTask(task)
                }
                findNavController().popBackStack()
            }
            it.buttonCancelTask.setOnClickListener { findNavController().popBackStack() }

            if (task != null) {
                it.textInputTaskName.editText?.setText(task.name, TextView.BufferType.EDITABLE)
                it.textInputTaskNote.editText?.setText(task.note, TextView.BufferType.EDITABLE)
                it.textInputTaskDate.editText?.setText(task.date, TextView.BufferType.EDITABLE)
                it.textInputTaskLocation.editText?.setText(
                    task.location, TextView.BufferType.EDITABLE
                )
            }
        }
    }
}