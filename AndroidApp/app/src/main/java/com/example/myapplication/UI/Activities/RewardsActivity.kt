package com.example.myapplication.UI.Activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class RewardsActivity : AppCompatActivity() {
    data class Reward(
        val title: String,
        val taskDescription: String,
        val isCompleted: Boolean,
        val imageUrl: Int // Add the imageUrl property
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        var currentPosition: Int
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rewards)
        supportActionBar?.title = "Rewards"

        val rewardsRecyclerView: RecyclerView = findViewById(R.id.rewardsRecyclerView)
        rewardsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Mock rewards data
        val rewardsList = mutableListOf<Reward>()
        rewardsList.add(Reward("Reward 1", "Complete Task 1", true, R.mipmap.ic_reward))
        rewardsList.add(Reward("Reward 2", "Complete Task 2", false, R.mipmap.ic_reward))
        rewardsList.add(Reward("Reward 3", "Complete Task 3", false, R.mipmap.ic_reward))
        rewardsList.add(Reward("Reward 4", "Complete Task 4", true, R.mipmap.ic_reward))
        rewardsList.add(Reward("Reward 5", "Complete Task 5", false, R.mipmap.ic_reward))

        // Create and set the adapter for the RecyclerView
        val adapter = RewardsAdapter(rewardsList)
        rewardsRecyclerView.adapter = adapter

        rewardsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val lastVisibleItem = layoutManager.findLastVisibleItemPosition()
                val totalItems = layoutManager.itemCount

                // When you reach the end, reset the position to loop
                if (lastVisibleItem == totalItems - 1) {
                    currentPosition = 0
                    rewardsRecyclerView.scrollToPosition(currentPosition)
                }
            }
        })

        var bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_profile -> {
                    val intent = Intent(this, DashboardActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.navigation_rewards -> {
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
                    val url = "https://localhost:8080" // Replace with your URL

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
}
