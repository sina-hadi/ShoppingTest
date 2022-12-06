package com.codinginflow.testproject.initial

sealed class LoginResult(
    val message: String? = null
) {
    object Success : LoginResult()
    class Error(message: String? = null) : LoginResult(message)
}