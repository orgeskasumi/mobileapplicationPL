package com.example.createaccountapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account1)  // Make sure this matches your layout file name

        // Link to the input fields and button in the layout
        val emailInput = findViewById<EditText>(R.id.emailEditText)
        val passwordInput = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.nextButton)

        // Set a click listener on the "Next" button
        loginButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            // Call validation functions and show errors if necessary
            if (!isValidEmail(email)) {
                emailInput.error = "Please enter a valid email address"
            } else if (!isValidPassword(password)) {
                passwordInput.error = "Password must be at least 8 characters"
            } else {
                // If both validations pass, show a success message
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                // Here you can add logic to navigate to the next screen or authenticate
            }
        }
    }

    // Function to validate email format
    private fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && email.contains("@")
    }

    // Function to validate password length
    private fun isValidPassword(password: String): Boolean {
        return password.length >= 8
    }
}
