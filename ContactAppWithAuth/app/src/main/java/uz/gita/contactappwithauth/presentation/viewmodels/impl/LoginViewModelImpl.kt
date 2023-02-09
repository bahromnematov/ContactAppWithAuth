package uz.gita.contactappwithauth.presentation.viewmodels.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.contactappwithauth.data.local.MySharedPref
import uz.gita.contactappwithauth.data.remote.ApiClient
import uz.gita.contactappwithauth.data.remote.api.AuthApi
import uz.gita.contactappwithauth.data.remote.requests.LoginRequest
import uz.gita.contactappwithauth.presentation.viewmodels.LoginViewModel
import uz.gita.contactappwithauth.utils.isConnected
import uz.gita.contactappwithauth.utils.myEnqueue

class LoginViewModelImpl : ViewModel(), LoginViewModel {
    override val progressLiveData= MutableLiveData<Boolean>()
    override val notConnectionLiveData= MutableLiveData<Unit>()
    override val openRegisterScreenLiveData= MutableLiveData<Unit>()
    override val openContactScreenLiveData= MutableLiveData<Unit>()
    override val errorLiveData= MutableLiveData<String>()
    private val api : AuthApi = ApiClient.retrofit.create(AuthApi::class.java)
    private val pref = MySharedPref.getMySharedPref()

    override fun loginUser(data: LoginRequest) {
        if (!isConnected()) {
            notConnectionLiveData.value = Unit
            return
        }
        progressLiveData.value = true
        api.login(data).myEnqueue(
            // onSuccess
            { response ->
                progressLiveData.value = false
                if (response.isSuccessful) {
                    response.body()?.let {
                        pref.token = it.token
                    }
                    openContactScreenLiveData.value = Unit
                } else {
                    errorLiveData.value = "Error"
                }
            },
            //onFail
            {
                progressLiveData.value = false
                errorLiveData.value = it.message
            })
    }

    override fun openRegisterScreen() {
        openRegisterScreenLiveData.value = Unit
    }
}
