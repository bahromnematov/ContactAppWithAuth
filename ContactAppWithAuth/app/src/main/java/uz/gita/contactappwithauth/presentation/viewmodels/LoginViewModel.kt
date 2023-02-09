package uz.gita.contactappwithauth.presentation.viewmodels

import androidx.lifecycle.LiveData
import uz.gita.contactappwithauth.data.remote.requests.LoginRequest

interface LoginViewModel {
    //Events
    val progressLiveData : LiveData<Boolean>
    val notConnectionLiveData : LiveData<Unit>
    val openRegisterScreenLiveData : LiveData<Unit>
    val openContactScreenLiveData : LiveData<Unit>
    val errorLiveData : LiveData<String>

    //Actions
    fun loginUser(data : LoginRequest)
    fun openRegisterScreen()
}



