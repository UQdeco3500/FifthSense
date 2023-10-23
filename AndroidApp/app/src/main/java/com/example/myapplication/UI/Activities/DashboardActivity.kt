package com.example.myapplication.UI.Activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportActionBar?.title = "Dashboard"

        var bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_profile -> {
                    true
                }
                R.id.navigation_rewards -> {
                    val intent = Intent(this, RewardsActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.navigation_timer -> {
                    val intent = Intent(this, TimerActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.navigation_chat -> {
                    // Define the URL you want to open
                    val url = "http://172.16.61.75:8080" // Replace with your URL

                    // Create an Intent to open the URL in the default web browser
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(browserIntent)
                    true
                }
                R.id.navigation_settings -> {
                    val intent = Intent(this, SettingsActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    finish()
                    true
                }
                else -> true
            }
        }
    }

    fun navigateToTimer(view: View) {
        startActivity(Intent(this, TimerActivity::class.java))
    }

    fun navigateToDashboard(view: View) {
        startActivity(Intent(this, DashboardActivity::class.java))
    }

    fun navigateToSettings(view: View) {
        startActivity(Intent(this, SettingsActivity::class.java))
    }

    fun navigateToRewards(view: View) {
        startActivity(Intent(this, RewardsActivity::class.java))
    }

    fun navigateToTask(view: View) {
        startActivity(Intent(this, TasksActivity::class.java))
    }

    fun navigateToProfile(view: View) {
        startActivity(Intent(this, ProfileActivity::class.java))
    }

    fun navigateToActivity(view: View) {
        startActivity(Intent(this, ActivityActivity::class.java))
    }

}
