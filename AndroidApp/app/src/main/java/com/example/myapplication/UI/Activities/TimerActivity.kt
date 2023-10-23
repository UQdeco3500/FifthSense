package com.example.myapplication.UI.Activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityTimerBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class TimerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTimerBinding
    private var timer: CountDownTimer? = null
    private var timeLeftInMillis: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        supportActionBar?.title = "Timer"


        binding = ActivityTimerBinding.bind(findViewById(R.id.rootLayout))
        setContentView(binding.root)

        setupUI()

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
                    val intent = Intent(this, RewardsActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.navigation_timer -> {

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

    private fun setupUI() {
        binding.hourPicker.minValue = 0
        binding.hourPicker.maxValue = 23
        binding.minutePicker.minValue = 0
        binding.minutePicker.maxValue = 59
        binding.secondPicker.minValue = 0
        binding.secondPicker.maxValue = 59

        binding.startButton.setOnClickListener {
            startTimer()
        }

        binding.pauseButton.setOnClickListener {
            pauseTimer()
        }

        binding.resetButton.setOnClickListener {
            resetTimer()
        }
    }

    private fun startTimer() {
        timer?.cancel()

        timeLeftInMillis =
            (binding.hourPicker.value * 60 * 60 + binding.minutePicker.value * 60 + binding.secondPicker.value) * 1000L

        timer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateCountDownText()
            }

            override fun onFinish() {
                binding.timerTextView.text = "00:00:00"
            }
        }.start()
    }

    private fun pauseTimer() {
        timer?.cancel()
    }

    private fun resetTimer() {
        timer?.cancel()
        binding.timerTextView.text = "00:00:00"
        binding.hourPicker.value = 0
        binding.minutePicker.value = 0
        binding.secondPicker.value = 0
    }

    private fun updateCountDownText() {
        val hours = (timeLeftInMillis / 1000) / 3600
        val minutes = ((timeLeftInMillis / 1000) % 3600) / 60
        val seconds = (timeLeftInMillis / 1000) % 60

        val timeFormatted = String.format("%02d:%02d:%02d", hours, minutes, seconds)
        binding.timerTextView.text = timeFormatted
    }
}