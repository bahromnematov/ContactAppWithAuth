package uz.gita.contactappwithauth.domain.usecase.impl

import uz.gita.contactappwithauth.data.model.StartScreenEnum
import uz.gita.contactappwithauth.domain.repository.AuthRepository
import uz.gita.contactappwithauth.domain.repository.impl.AuthRepositoryImpl
import uz.gita.contactappwithauth.domain.usecase.StartScreenUseCase
import javax.inject.Inject

class StartScreenUseCaseImpl @Inject constructor(private val repository : AuthRepository) : StartScreenUseCase {
    override suspend fun startScreenEnum(): StartScreenEnum = repository.startScreen()
}

