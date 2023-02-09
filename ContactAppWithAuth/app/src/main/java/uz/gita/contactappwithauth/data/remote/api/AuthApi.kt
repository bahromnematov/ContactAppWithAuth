package uz.gita.contactappwithauth.data.remote.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import uz.gita.contactappwithauth.data.remote.requests.CodeVerifyRequest
import uz.gita.contactappwithauth.data.remote.requests.LoginRequest
import uz.gita.contactappwithauth.data.remote.requests.RegisterRequest
import uz.gita.contactappwithauth.data.remote.responses.CodeVerifyResponse
import uz.gita.contactappwithauth.data.remote.responses.LoginResponse
import uz.gita.contactappwithauth.data.remote.responses.RegisterResponse

interface AuthApi {

    @POST("register")
    fun register(@Body data: RegisterRequest): Call<RegisterResponse>

    @POST("register/verify")
    fun codeVerify(@Body data : CodeVerifyRequest) : Call<CodeVerifyResponse>

    @POST("login")
    fun login(@Body data : LoginRequest) : Call<LoginResponse>
}

