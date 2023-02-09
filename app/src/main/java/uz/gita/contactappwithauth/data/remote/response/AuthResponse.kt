package uz.gita.contactappwithauth.data.remote.response

sealed class AuthResponse {
    data class RegisterResponse(
        val message: String,
        val data: Data
    )

    data class LoginResponse(
        val message: String,
        val data: Data
    )

    data class LogoutResponse(
        val message: String,
        val data: Any?
    )

    data class Data(
        val name: String,
        val token: String
    )

    //  ***********************
    data class UnRegisterResponse(
        val message: String,
        val data: UnRegisterData
    )

    data class UnRegisterData(
        val name: String,
        val password: String
    )
}



