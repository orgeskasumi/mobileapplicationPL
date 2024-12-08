package com.example.createaccountapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.createaccountapp.R
import com.google.android.material.button.MaterialButton

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Update the IDs to match the ones used in the XML layout
        val emailInput = view.findViewById<EditText>(R.id.emailEditText1)
        val passwordInput = view.findViewById<EditText>(R.id.passwordEditText1)
        val loginButton = view.findViewById<MaterialButton>(R.id.nextButton1)
        val registerButton = view.findViewById<MaterialButton>(R.id.registerNowButton1)

        val sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // Validate input fields
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Please fill in both fields", Toast.LENGTH_SHORT).show()
            } else {
                val savedPassword = sharedPreferences.getString(email, null)
                if (savedPassword != null && savedPassword == password) {
                    Toast.makeText(context, "Login successful!", Toast.LENGTH_SHORT).show()
                    // Navigate to the next screen (could be another Fragment or Activity)
                    // startActivity(Intent(context, NextActivity::class.java))
                } else {
                    Toast.makeText(context, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Handle Register button click
        registerButton.setOnClickListener {
            val registerFragment = RegisterFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, registerFragment)
                .addToBackStack(null) // Allows back navigation
                .commit()
        }
    }
}
