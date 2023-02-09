package uz.gita.contactappwithauth.presentation.viewmodels.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.contactappwithauth.presentation.viewmodels.SplashViewModel
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class SplashViewModelImpl : ViewModel(), SplashViewModel {
    override val openNextScreenLiveData = MutableLiveData<Unit>()

    init {
        val thread = Executors.newSingleThreadExecutor()
        thread.execute {
            thread.awaitTermination(2, TimeUnit.SECONDS)
            openNextScreenLiveData.postValue(Unit)
            thread.shutdown()
        }
    }
}