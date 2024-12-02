package com.example.createaccountapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account1)

        val emailInput = findViewById<EditText>(R.id.emailEditText)
        val passwordInput = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<MaterialButton>(R.id.nextButton)
        val registerButton = findViewById<MaterialButton>(R.id.registerNowButton)

        val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        registerButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Save the email and password to SharedPreferences
                with(sharedPreferences.edit()) {
                    putString(email, password)
                    apply()
                }
                Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        loginButton.setOnClickListener {
            Log.d("LoginButton", "Next button clicked")
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            when {
                email.isEmpty() -> {
                    Log.d("LoginButton", "Email is empty")
                    Toast.makeText(this, "Email field is not filled!", Toast.LENGTH_SHORT).show()
                }
                password.isEmpty() -> {
                    Log.d("LoginButton", "Password is empty")
                    Toast.makeText(this, "Password field is not filled!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Log.d("LoginButton", "Checking credentials")
                    val savedPassword = sharedPreferences.getString(email, null)
                    if (savedPassword != null && savedPassword == password) {
                        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, BlankActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Invalid email or password. Please try again.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && email.contains("@")
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length >= 8
    }
}
