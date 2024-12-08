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
import com.google.android.material.checkbox.MaterialCheckBox
import android.widget.TextView

class RegisterFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Updated IDs based on new XML layout
        val emailInput = view.findViewById<EditText>(R.id.validEmailEditText2)  // updated ID
        val passwordInput = view.findViewById<EditText>(R.id.strongPasswordEditText2)  // updated ID
        val registerButton = view.findViewById<MaterialButton>(R.id.registerButton2)  // updated ID
        val agreeTermsCheckBox = view.findViewById<MaterialCheckBox>(R.id.agreeTermsCheckBox2)  // updated ID
        val alreadyMemberTextView = view.findViewById<TextView>(R.id.alreadyMemberTextView2)  // "Already a member? Log in" TextView

        val sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        registerButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // Validate input fields and terms agreement
            if (email.isNotEmpty() && password.isNotEmpty() && agreeTermsCheckBox.isChecked) {
                with(sharedPreferences.edit()) {
                    putString(email, password)  // Save email and password
                    apply()  // Apply changes to SharedPreferences
                }
                Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT).show()

                // Go back to LoginFragment
                val loginFragment = LoginFragment()  // Create LoginFragment instance
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, loginFragment)  // Replace RegisterFragment with LoginFragment
                    .commit()
            } else {
                Toast.makeText(context, "Please fill in all fields and agree to terms", Toast.LENGTH_SHORT).show()
            }
        }

        // Handle "Already a member? Log in" TextView click
        alreadyMemberTextView.setOnClickListener {
            val loginFragment = LoginFragment()  // Create LoginFragment instance
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, loginFragment)  // Replace RegisterFragment with LoginFragment
                .commit()
        }
    }
}
