package com.example.todolistpairprogramming.ui.complete

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistpairprogramming.databinding.FragmentTaskListBinding
import com.example.todolistpairprogramming.viewmodel.TaskViewModel

class CompleteTaskListFragment : Fragment() {
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
        Log.d("TaskListFragment", "已完成任務畫面")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}