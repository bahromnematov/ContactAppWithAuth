package uz.gita.contactappwithauth.domain.usecase.impl

import android.util.Log
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import uz.gita.contactappwithauth.data.remote.request.AuthRequest
import uz.gita.contactappwithauth.domain.repository.AuthRepository
import uz.gita.contactappwithauth.domain.repository.impl.AuthRepositoryImpl
import uz.gita.contactappwithauth.domain.usecase.LoginUseCase
import javax.inject.Inject
import javax.inject.Singleton

//class LoginUseCaseImpl  constructor(private val repository: AuthRepository) : LoginUseCase {
@Singleton
class LoginUseCaseImpl @Inject constructor(private val repository: AuthRepository) : LoginUseCase {

    init {
        Log.d("TTT", "call $this")
    }
    override fun userLogin(data: AuthRequest): Flow<Result<Unit>> = flow<Result<Unit>> {
        emit(repository.userLogin(data))
    }.catch {
        emit(Result.failure(Exception(it.message)))
    }.flowOn(Dispatchers.IO)
}
