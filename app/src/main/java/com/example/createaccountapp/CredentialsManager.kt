package com.example.createaccountapp

import android.content.Context
import android.content.SharedPreferences

object CredentialsManager {

    private const val PREF_NAME = "UserCredentials"
    private const val KEY_EMAIL = "email"
    private const val KEY_PASSWORD = "password"

    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun register(email: String, password: String): String {
        val editor = sharedPreferences.edit()
        editor.putString(KEY_EMAIL, email)
        editor.putString(KEY_PASSWORD, password)
        editor.apply()
        return "Account created successfully"
    }

    fun login(email: String, password: String): Boolean {
        val savedEmail = sharedPreferences.getString(KEY_EMAIL, null)
        val savedPassword = sharedPreferences.getString(KEY_PASSWORD, null)
        return savedEmail == email && savedPassword == password
    }
}
