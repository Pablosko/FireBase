package com.pablo_daniel.interficies.googleAuth

data class SignInState(
    val isSignInSuccessful: Boolean =false,
    val signInError: String? = null
)
