package com.codinginflow.testproject.initial

object RegistrationUtil {

    val existingUsers = listOf("Peter", "Carl")

    fun validateRegistrationInput(
        username: String, password: String, confirmedPassword: String
    ): LoginResult {
        val result: LoginResult = if (username.isEmpty() || password.isEmpty()) {
            LoginResult.Error("Found empty field")
        } else if (username in existingUsers) {
            LoginResult.Error("Username already taken")
        } else if (password != confirmedPassword) {
            LoginResult.Error("Password not valid")
        } else if (password.length < 2) {
            LoginResult.Error("Password is short")
        } else {
            LoginResult.Success
        }

        return result
    }
}