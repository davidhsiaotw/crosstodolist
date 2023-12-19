package com.example.todolistpairprogramming.ui.incomplete

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistpairprogramming.R
import com.example.todolistpairprogramming.ui.TaskAdapter
import com.example.todolistpairprogramming.databinding.FragmentTaskListBinding
import com.example.todolistpairprogramming.viewmodel.TaskViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TaskListFragment : Fragment() {
    private val taskViewModel: TaskViewModel by activityViewModels { TaskViewModel.Factory }
    private var _binding: FragmentTaskListBinding? = null
    private lateinit var recyclerView: RecyclerView

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTaskListBinding.inflate(inflater, container, false)
        Log.d("TaskListFragment", "未完成任務畫面")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.let {
            recyclerView = it.root.getViewById(R.id.recyclerview) as RecyclerView
            recyclerView.adapter = TaskAdapter(listOf(), onClickListener = {
                // TODO: click to 1. navigate to TaskFragment and 2. store selected task
            })
        }
    }

    override fun onResume() {
        super.onResume()
        activity?.title = "Todo List"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}