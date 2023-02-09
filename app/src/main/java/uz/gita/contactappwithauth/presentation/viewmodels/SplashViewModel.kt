package uz.gita.contactappwithauth.presentation.viewmodels

import androidx.lifecycle.LiveData

interface SplashViewModel {
    val openLoginScreenLiveData: LiveData<Unit>
    val openContactScreenLiveData: LiveData<Unit>
}