package com.example.todolistpairprogramming.ui.edit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
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
        bind(Task(id = -1, date = "12/31/2023"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun bind(task: Task) {
        _binding?.let {
            it.buttonSaveTask.setOnClickListener {
                // TODO: update task if a task is selected (TaskViewModel), otherwise add a new task
                taskViewModel.test()
                findNavController().popBackStack()
            }
            it.buttonCancelTask.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}