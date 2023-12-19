package com.example.todolistpairprogramming

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.todolistpairprogramming.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

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
            it.isChecked = true
            binding.layoutDrawer.close()
            when (it.itemId) {
                R.id.item_add_task -> {
                    // TODO: navigate to TaskFragment
                    Log.d("Navigation Drawer", "TaskFragment is displaying")
                }

                R.id.item_incomplete_tasks -> {
                    // TODO: navigate to TaskListFragment
                    Log.d("Navigation Drawer", "TaskListFragment is displaying")
                }

                R.id.item_complete_tasks -> {
                    // TODO: navigate to CompleteTaskListFragment
                    Log.d("Navigation Drawer", "CompleteTaskListFragment is displaying")
                }
            }

            true
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        navController = navHostFragment.navController
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
                // TODO: navigate to TaskFragment
                // NOTE: current fragment could be TaskListFragment or InCompleteTaskListFragment
                // TaskFragment should always be on the top of the back stack
                // https://developer.android.com/guide/navigation/backstack
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