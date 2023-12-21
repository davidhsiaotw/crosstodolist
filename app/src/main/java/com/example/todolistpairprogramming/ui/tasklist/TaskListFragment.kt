package com.example.todolistpairprogramming.ui.tasklist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistpairprogramming.R
import com.example.todolistpairprogramming.ui.TaskAdapter
import com.example.todolistpairprogramming.databinding.FragmentTaskListBinding
import com.example.todolistpairprogramming.model.Task
import com.example.todolistpairprogramming.ui.Status
import com.example.todolistpairprogramming.viewmodel.TaskViewModel
import kotlin.Exception

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TaskListFragment : Fragment() {
    private val taskViewModel: TaskViewModel by activityViewModels { TaskViewModel.Factory }
    private var isComplete: Status? = null
    private var _binding: FragmentTaskListBinding? = null
    private lateinit var recyclerView: RecyclerView

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTaskListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs: TaskListFragmentArgs by navArgs()
        isComplete = safeArgs.isComplete

        _binding?.let {
            recyclerView = it.root.getViewById(R.id.recyclerview) as RecyclerView

            try {
                var tasks: LiveData<List<Task>> = MutableLiveData()
                when (isComplete) {
                    Status.INCOMPLETE -> {
                        Log.d("TaskListFragment", "未完成畫面")
                        activity?.title = "Todo List"
                        tasks = taskViewModel.incompleteTasks
                    }

                    Status.COMPLETE -> {
                        Log.d("TaskListFragment", "已完成畫面")
                        activity?.title = "Complete Tasks"
                        tasks = taskViewModel.completeTasks
                    }

                    else -> Log.e("TaskListFragment", "isComplete is null")
                }
                tasks.observe(viewLifecycleOwner) { t ->
                    recyclerView.adapter = TaskAdapter(t, { task ->
                        findNavController().navigate(
                            R.id.EditTaskFragment, bundleOf("task" to task)
                        )
                    }, { task -> taskViewModel.updateTask(task) })
                }
            } catch (e: Exception) {
                Log.e("TasksListFragment.onViewCreated", e.message ?: "")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}