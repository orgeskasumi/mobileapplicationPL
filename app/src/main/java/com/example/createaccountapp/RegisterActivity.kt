package com.example.createaccountapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.textfield.TextInputEditText
import android.widget.TextView
import com.example.createaccountapp.CredentialsManager // Assuming this is in the same package

class RegisterActivity : AppCompatActivity() {

    private lateinit var fullNameEditText: TextInputEditText
    private lateinit var validEmailEditText: TextInputEditText
    private lateinit var phoneNumberEditText: TextInputEditText
    private lateinit var strongPasswordEditText: TextInputEditText
    private lateinit var agreeTermsCheckBox: MaterialCheckBox
    private lateinit var registerButton: MaterialButton
    private lateinit var alreadyMemberTextView: TextView
    private lateinit var credentialsManager: CredentialsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account2)
        CredentialsManager.init(this)

        credentialsManager = CredentialsManager
        fullNameEditText = findViewById(R.id.fullNameEditText)
        validEmailEditText = findViewById(R.id.validEmailEditText)
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText)
        strongPasswordEditText = findViewById(R.id.strongPasswordEditText)
        agreeTermsCheckBox = findViewById(R.id.agreeTermsCheckBox)
        registerButton = findViewById(R.id.registerButton)
        alreadyMemberTextView = findViewById(R.id.alreadyMemberTextView)

        registerButton.setOnClickListener {
            handleRegister()
        }
        alreadyMemberTextView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun handleRegister() {

        val fullName = fullNameEditText.text.toString().trim()
        val email = validEmailEditText.text.toString().trim()
        val phone = phoneNumberEditText.text.toString().trim()
        val password = strongPasswordEditText.text.toString().trim()

        if (!agreeTermsCheckBox.isChecked) {
            Toast.makeText(this, "Please agree to the terms and conditions.", Toast.LENGTH_SHORT).show()
            return
        }

        if (fullName.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "All fields are required.", Toast.LENGTH_SHORT).show()
            return
        }

        val result = credentialsManager.register(email, password)

        if (result == "Account created successfully") {
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        }
    }
}
