package com.pablo_daniel.interficies.googleAuth

data class SignInResult(
    val data: UserData?,
    val errorMessage: String?
)

data class UserData(
    val userId: String?,
    val username: String?,
    val profilePictureUrl: String?
)
