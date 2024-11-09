package com.example.createaccountapp

class CredentialsManager {

    private val validEmail = "testtest@gmail.com"
    private val validPassword = "qwerty"

    fun isEmailCorrect(email: String): Boolean {
        return email == validEmail
    }


    fun isPasswordCorrect(password: String): Boolean {
        return password == validPassword
    }
}
