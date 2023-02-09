package uz.gita.contactappwithauth.presentation.ui.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.contactappwithauth.R
import uz.gita.contactappwithauth.presentation.viewmodels.SplashViewModel
import uz.gita.contactappwithauth.presentation.viewmodels.impl.SplashViewModelImpl

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen : Fragment(R.layout.screen_splash) {
    private val viewmodel: SplashViewModel by viewModels<SplashViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewmodel.openLoginScreenLiveData.observe(viewLifecycleOwner, openLoginScreenObserver)
        viewmodel.openContactScreenLiveData.observe(viewLifecycleOwner, openContactScreenObserver)
    }

    private val openLoginScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_splashScreen_to_loginScreen)
    }

    private val openContactScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_splashScreen_to_contactScreen)
    }
}
