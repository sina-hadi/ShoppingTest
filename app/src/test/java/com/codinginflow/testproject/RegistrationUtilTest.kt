package com.codinginflow.testproject

import com.codinginflow.testproject.initial.LoginResult
import com.codinginflow.testproject.initial.RegistrationUtil
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

internal class RegistrationUtilTest {

    private lateinit var existingUsers: List<String>
    private lateinit var registrationUtil: RegistrationUtil

    @Before
    fun setup() {
        registrationUtil = RegistrationUtil
        existingUsers = registrationUtil.existingUsers
    }

    @Test
    fun emptyUsername_ReturnFalse() {
        val result = registrationUtil.validateRegistrationInput(
            "", "123", "123"
        )
        assertTrue(result is LoginResult.Error)
    }


    @Test
    fun shortPassword_ReturnFalse() {
        val result = registrationUtil.validateRegistrationInput(
            "Philipp", "1", "1"
        )
        assertTrue(result is LoginResult.Error)
    }

    @Test
    fun emptyPassword_ReturnFalse() {
        val result = registrationUtil.validateRegistrationInput(
            "Philipp", "", ""
        )
        assertTrue(result is LoginResult.Error)
    }

    @Test
    fun notValidRepeatedPassword_ReturnFalse() {
        val result = registrationUtil.validateRegistrationInput(
            "Philipp", "123", "321"
        )
        assertTrue(result is LoginResult.Error)
    }

    @Test
    fun alreadyTakenUsername_ReturnFalse() {
        val result = registrationUtil.validateRegistrationInput(
            "Carl", "123", "123"
        )
        assertTrue(result is LoginResult.Error)
    }

    @Test
    fun validUsernameAndPassword_ReturnTrue() {
        val result = registrationUtil.validateRegistrationInput(
            "Philipp", "123", "123"
        )
        assertTrue(result is LoginResult.Success)
    }

}