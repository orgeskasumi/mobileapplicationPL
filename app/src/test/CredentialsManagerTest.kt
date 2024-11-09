package com.example.createaccountapp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CredentialsManagerTest {

    private val credentialsManager = CredentialsManager()

    @Test
    fun givenCorrectEmail_thenReturnTrue() {
        val isEmailCorrect = credentialsManager.isEmailCorrect("testtest@gmail.com")
        assertEquals(true, isEmailCorrect)
    }

    // Test with incorrect email
    @Test
    fun givenIncorrectEmail_thenReturnFalse() {
        val isEmailCorrect = credentialsManager.isEmailCorrect("wrongtestt@gmail.com")
        assertEquals(false, isEmailCorrect)
    }

    @Test
    fun givenCorrectPassword_thenReturnTrue() {
        val isPasswordCorrect = credentialsManager.isPasswordCorrect("qwerty")
        assertEquals(true, isPasswordCorrect)
    }

    // Test with incorrect password
    @Test
    fun givenIncorrectPassword_thenReturnFalse() {
        val isPasswordCorrect = credentialsManager.isPasswordCorrect("12345678")
        assertEquals(false, isPasswordCorrect)
    }
}
// i dont know how to do it better because i need some help on exersize 2 soooo plz dont judge me