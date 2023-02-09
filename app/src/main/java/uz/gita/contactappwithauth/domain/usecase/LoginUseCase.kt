package uz.gita.contactappwithauth.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.contactappwithauth.data.remote.request.AuthRequest

interface LoginUseCase {
    fun userLogin(data: AuthRequest) : Flow<Result<Unit>>
}