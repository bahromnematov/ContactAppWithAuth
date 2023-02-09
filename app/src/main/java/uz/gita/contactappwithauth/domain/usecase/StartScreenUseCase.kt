package uz.gita.contactappwithauth.domain.usecase

import uz.gita.contactappwithauth.data.model.StartScreenEnum

interface StartScreenUseCase {
    suspend fun startScreenEnum() : StartScreenEnum
}