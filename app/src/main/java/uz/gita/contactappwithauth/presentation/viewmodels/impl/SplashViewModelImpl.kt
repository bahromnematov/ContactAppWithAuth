package uz.gita.contactappwithauth.presentation.viewmodels.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.contactappwithauth.data.model.StartScreenEnum
import uz.gita.contactappwithauth.domain.repository.AuthRepository
import uz.gita.contactappwithauth.domain.usecase.LoginUseCase
import uz.gita.contactappwithauth.domain.usecase.StartScreenUseCase
import uz.gita.contactappwithauth.presentation.viewmodels.LoginViewModel
import uz.gita.contactappwithauth.presentation.viewmodels.SplashViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val startScreenUseCase: StartScreenUseCase,
    private val loginUseCase: LoginUseCase
) : ViewModel(), SplashViewModel {
    override val openLoginScreenLiveData = MutableLiveData<Unit>()
    override val openContactScreenLiveData = MutableLiveData<Unit>()

    init {
        viewModelScope.launch {
            delay(1000)
            if (startScreenUseCase.startScreenEnum() == StartScreenEnum.LOGIN) openLoginScreenLiveData.postValue(Unit)
            else openContactScreenLiveData.postValue(Unit)
        }
    }
}

