package com.example.createaccountapp

object CredentialsManager {

    private val credentialsMap: MutableMap<String, String> = mutableMapOf()

    fun register(email: String, password: String): String {

        if (credentialsMap.containsKey(email)) {
            return "Error: Email is already taken"
        } else {
            credentialsMap[email] = password
            return "Account created successfully"
        }
    }

    fun login(email: String, password: String): Boolean {
        return credentialsMap[email] == password
    }
}
