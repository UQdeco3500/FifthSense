package com.example.myapplication.UI.Activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class SettingsActivity : AppCompatActivity() {
    private lateinit var popupWindow: PopupWindow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        supportActionBar?.title = "Settings"

        val qaButton = findViewById<Button>(R.id.qaButton)
        val feedbackButton = findViewById<Button>(R.id.feedbackButton)
        val privacyClauseButton = findViewById<Button>(R.id.privacyClauseButton)
        val userAgreementsButton = findViewById<Button>(R.id.userAgreementsButton)

        val popupView = layoutInflater.inflate(R.layout.popup_layout, null)
        popupWindow = PopupWindow(popupView, -2, -2, true)

        qaButton.setOnClickListener {
            showPopup("Q&A")
        }

        feedbackButton.setOnClickListener {
            showPopup("Feedback")
        }

        privacyClauseButton.setOnClickListener {
            showPopup("Privacy Clause")
        }

        userAgreementsButton.setOnClickListener {
            showPopup("User Agreements")
        }

        val gameTimeChallenge = findViewById<Switch>(R.id.gameTimeChallenge)

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
                    true
                }
                else -> true
            }
        }
    }

    private fun showPopup(message: String) {
        val builder = AlertDialog.Builder(this)
        val customView = layoutInflater.inflate(R.layout.popup_layout, null)
        builder.setView(customView)
        val popupImage = customView.findViewById<ImageView>(R.id.popupImage)
        when (message) {
            "Q&A" -> {
                popupImage.setImageResource(R.mipmap.ic_qna)
            }
            "Feedback" -> {
                popupImage.setImageResource(R.mipmap.ic_feedback)
            }
            "Privacy Clause" -> {
                popupImage.setImageResource(R.mipmap.ic_privacy)
            }
            "User Agreements" -> {
                popupImage.setImageResource(R.mipmap.ic_user_agreement)
            }
        }
        val popupMessage = customView.findViewById<TextView>(R.id.popupMessage)
        popupMessage.text = message
        val dialog = builder.create()
        dialog.show()
    }

    fun navigateToDashboard(view: View) {
        startActivity(Intent(this, DashboardActivity::class.java))
    }
}
