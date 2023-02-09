package uz.gita.contactappwithauth.domain.repository.impl

import com.google.gson.Gson
import uz.gita.contactappwithauth.data.local.AppPreferences
import uz.gita.contactappwithauth.data.model.StartScreenEnum
import uz.gita.contactappwithauth.data.remote.api.AuthApi
import uz.gita.contactappwithauth.data.remote.request.AuthRequest
import uz.gita.contactappwithauth.domain.repository.AuthRepository
import uz.gita.mycontactbyretrofit.data.remote.response.ErrorResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val pref: AppPreferences,
    private val gson: Gson
) : AuthRepository {

    override suspend fun userLogin(data: AuthRequest): Result<Unit> {
        val response = authApi.login(data)
        if (response.isSuccessful) {
            response.body()?.apply {
                pref.startScreen = StartScreenEnum.CONTACT
                pref.token = this.data.token
                return Result.success(Unit)
            }
        } else {
            response.errorBody()?.apply {
                val errorResponse = gson.fromJson(this.string(), ErrorResponse::class.java)
                return Result.failure(Exception(errorResponse.message))
            }
        }
        return Result.failure(Exception("Not found!!"))
    }

    override suspend fun startScreen(): StartScreenEnum = pref.startScreen
}