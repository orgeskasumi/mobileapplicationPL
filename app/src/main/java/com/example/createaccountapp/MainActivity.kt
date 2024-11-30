package com.example.createaccountapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account1)

        val emailInput = findViewById<EditText>(R.id.emailEditText)
        val passwordInput = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.nextButton)


        val registerButton = findViewById<MaterialButton>(R.id.registerNowButton)

        registerButton.setOnClickListener {
            Log.d("TAG", "Clicked register")
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            if (!isValidEmail(email)) {
                emailInput.error = "Please enter a valid email address"
            } else if (!isValidPassword(password)) {
                passwordInput.error = "Password must be at least 8 characters"
            } else {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
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
