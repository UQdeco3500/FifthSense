package com.example.myapplication.UI.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var forgotPasswordText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.title = "Welcome to PlayRight"

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        forgotPasswordText = findViewById(R.id.forgotPasswordText)

        loginButton.setOnClickListener {
            // Mock successful login
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (username == "samarth" && password == "test1234") {
                // Successful login, you can navigate to another activity here
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Unsuccessful login, show an error message
                showErrorPopup(getString(R.string.login_error))
            }
        }

        forgotPasswordText.setOnClickListener {
            showForgotPasswordPopup()
        }
    }

    private fun showErrorPopup(errorMessage: String) {
        val builder = AlertDialog.Builder(this)
        val customView = layoutInflater.inflate(R.layout.custom_error_dialog, null)
        builder.setView(customView)
        val errorTextView = customView.findViewById<TextView>(R.id.errorMessage)
        errorTextView.text = errorMessage
        val dialog = builder.create()
        dialog.show()
    }

    private fun showForgotPasswordPopup() {
        val builder = AlertDialog.Builder(this)
        val customView = layoutInflater.inflate(R.layout.custom_forgot_password_dialog, null)
        builder.setView(customView)

        val emailEditText = customView.findViewById<EditText>(R.id.emailEditText)
        val recoverButton = customView.findViewById<Button>(R.id.recoverButton)

        val dialog = builder.create()
        dialog.show()

        recoverButton.setOnClickListener {
            val email = emailEditText.text.toString()
            // Implement your password recovery logic here, e.g., sending a recovery email.
            // You can also close the dialog after recovery is initiated.
            dialog.dismiss()
        }
    }

}
