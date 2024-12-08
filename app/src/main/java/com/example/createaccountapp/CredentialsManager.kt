package com.example.createaccountapp

import android.content.Context
import android.content.SharedPreferences

object CredentialsManager {

    private const val PREF_NAME = "UserCredentials"

    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    // Register a user by saving email and password to SharedPreferences
    fun register(email: String, password: String): String {
        val editor = sharedPreferences.edit()

        // Check if the user already exists
        val existingPassword = sharedPreferences.getString(email, null)
        if (existingPassword != null) {
            return "User already exists!"
        }

        // Store the email and password
        editor.putString(email, password)
        editor.apply()
        return "Account created successfully"
    }

    // Log in a user by checking if the email and password match
    fun login(email: String, password: String): Boolean {
        val savedPassword = sharedPreferences.getString(email, null)
        return savedPassword == password
    }
}
