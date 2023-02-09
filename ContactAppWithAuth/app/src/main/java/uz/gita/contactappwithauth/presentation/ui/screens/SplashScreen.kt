package uz.gita.contactappwithauth.presentation.ui.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.contactappwithauth.R
import uz.gita.contactappwithauth.databinding.ScreenSplashBinding
import uz.gita.contactappwithauth.presentation.viewmodels.SplashViewModel
import uz.gita.contactappwithauth.presentation.viewmodels.impl.SplashViewModelImpl
import uz.gita.contactappwithauth.utils.myApply

@SuppressLint("CustomSplashScreen")
class SplashScreen : Fragment(R.layout.screen_splash) {
    private val binding by viewBinding(ScreenSplashBinding::bind)
    private val viewModel : SplashViewModel by viewModels<SplashViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)= binding.myApply{
        viewModel.openNextScreenLiveData.observe(viewLifecycleOwner, openNextScreenObserver)
    }

    private val openNextScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_splashScreen_to_loginScreen)
    }
}