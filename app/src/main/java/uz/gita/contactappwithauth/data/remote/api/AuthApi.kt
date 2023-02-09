package uz.gita.contactappwithauth.data.remote.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.gita.contactappwithauth.data.remote.request.AuthRequest
import uz.gita.contactappwithauth.data.remote.response.AuthResponse

interface AuthApi {

    @POST("/register")
    suspend fun register(@Body data : AuthRequest) : Response<AuthResponse.RegisterResponse>

    @POST("/login")
    suspend fun login(@Body data: AuthRequest) : Response<AuthResponse.LoginResponse>

    @POST("/logout")
    fun logout(@Body data: AuthRequest) : Call<AuthResponse.LogoutResponse>

    @POST("/unregister")
    fun unRegister(@Body data: AuthRequest) : Call<AuthResponse.UnRegisterResponse>
}


