package uz.gita.contactappwithauth.presentation.viewmodels.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.gita.contactappwithauth.data.remote.request.AuthRequest
import uz.gita.contactappwithauth.domain.usecase.LoginUseCase
import uz.gita.contactappwithauth.presentation.viewmodels.LoginViewModel
import uz.gita.contactappwithauth.utils.ConnectionUtil
import javax.inject.Inject

@HiltViewModel
class LoginViewModelImpl @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val loginUseCase2: LoginUseCase,
    private val loginUseCase3: LoginUseCase,
    private val connectionUtil: ConnectionUtil
) : ViewModel(), LoginViewModel {
    override val openRegisterScreenLiveData = MutableLiveData<Unit>()
    override val openContactScreenLiveData = MutableLiveData<Unit>()
    override val notConnectionLiveData = MutableLiveData<Unit>()
    override val changeButtonStatusLiveData = MutableLiveData<Boolean>()
    override val progressLiveData = MutableLiveData<Boolean>()
    override val errorLiveData = MutableLiveData<String>()
    private var loginJob: Job? = null

    override fun userLogin(name: String, password: String) {
        if (!connectionUtil.isConnected()) {
            notConnectionLiveData.value = Unit
            return
        }
        progressLiveData.value = true
        changeButtonStatusLiveData.value = false
        loginJob = viewModelScope.launch {
            loginUseCase.userLogin(AuthRequest(name, password)).onEach {
                progressLiveData.value = false
                changeButtonStatusLiveData.value = true
                it.onSuccess {
                    openContactScreenLiveData.value = Unit
                }
                it.onFailure {
                    errorLiveData.value = it.message
                }
            }
        }
    }

    override fun openRegisterScreen() {
        loginJob?.let { if (it.isActive) it.cancel() }
        openRegisterScreenLiveData.value = Unit
    }

}