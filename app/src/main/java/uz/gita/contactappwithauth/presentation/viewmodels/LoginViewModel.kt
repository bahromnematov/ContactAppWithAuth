package uz.gita.contactappwithauth.presentation.viewmodels

import androidx.lifecycle.LiveData

interface LoginViewModel {
    val openRegisterScreenLiveData: LiveData<Unit>
    val openContactScreenLiveData: LiveData<Unit>
    val notConnectionLiveData: LiveData<Unit>
    val changeButtonStatusLiveData: LiveData<Boolean>
    val progressLiveData: LiveData<Boolean>
    val errorLiveData: LiveData<String>

    fun userLogin(name: String, password: String)
    fun openRegisterScreen()

}

