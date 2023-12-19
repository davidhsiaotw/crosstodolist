package com.example.todolistpairprogramming

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.todolistpairprogramming.databinding.ActivityMainBinding
import com.example.todolistpairprogramming.viewmodel.TaskViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: TaskViewModel by viewModels { TaskViewModel.Factory }
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener {
            binding.layoutDrawer.open()
        }


        // https://github.com/material-components/material-components-android/blob/master/docs/components/NavigationDrawer.md
        binding.navigationDrawer.setNavigationItemSelectedListener {
            binding.layoutDrawer.close()
            when (it.itemId) {
                R.id.item_add_task -> {
                    if (navController.currentDestination?.id != R.id.EditTaskFragment)
                        navController.navigate(R.id.EditTaskFragment)
                }

                R.id.item_incomplete_tasks -> {
                    navController.popBackStack(R.id.IncompleteTasksFragment, false)
                }

                R.id.item_complete_tasks -> {
                    if (!navController.popBackStack(R.id.EditTaskFragment, true)) {
                        navController.navigate(R.id.CompleteTasksFragment)
                    }
                }
            }
            true
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.EditTaskFragment -> binding.navigationDrawer.setCheckedItem(R.id.item_add_task)
                R.id.IncompleteTasksFragment -> binding.navigationDrawer.setCheckedItem(R.id.item_incomplete_tasks)
                R.id.CompleteTasksFragment -> binding.navigationDrawer.setCheckedItem(R.id.item_complete_tasks)
            }
            println("number is ${viewModel.number.value}")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_top_app_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.item_add_task -> {
                if (navController.currentDestination?.id != R.id.EditTaskFragment)
                    navController.navigate(R.id.EditTaskFragment)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            navController, binding.layoutDrawer
        ) || super.onSupportNavigateUp()
    }
}