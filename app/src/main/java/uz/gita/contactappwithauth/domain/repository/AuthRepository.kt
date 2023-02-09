package uz.gita.contactappwithauth.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.contactappwithauth.data.model.StartScreenEnum
import uz.gita.contactappwithauth.data.remote.request.AuthRequest

interface AuthRepository {
    suspend fun userLogin(data: AuthRequest): Result<Unit>
    suspend fun startScreen(): StartScreenEnum
}