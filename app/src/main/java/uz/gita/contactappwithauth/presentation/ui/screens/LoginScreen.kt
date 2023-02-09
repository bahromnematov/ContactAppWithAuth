package uz.gita.contactappwithauth.presentation.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.contactappwithauth.R
import uz.gita.contactappwithauth.databinding.ScreenLoginBinding
import uz.gita.contactappwithauth.domain.repository.impl.AuthRepositoryImpl
import uz.gita.contactappwithauth.domain.usecase.LoginUseCase
import uz.gita.contactappwithauth.presentation.viewmodels.LoginViewModel
import uz.gita.contactappwithauth.presentation.viewmodels.impl.LoginViewModelImpl
import uz.gita.contactappwithauth.utils.*
import javax.inject.Inject

@AndroidEntryPoint
class LoginScreen : Fragment(R.layout.screen_login) {
    private val viewModel: LoginViewModel by viewModels<LoginViewModelImpl>()
    private val binding by viewBinding(ScreenLoginBinding::bind)
    private var boolPassword = false
    private var boolName = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openRegisterScreenLiveData.observe(this, openRegisterScreenObserver)
        viewModel.openContactScreenLiveData.observe(this, openContactScreenObserver)
        viewModel.notConnectionLiveData.observe(this, notConnectionObserver)
        viewModel.errorLiveData.observe(this, errorObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.myApply {
        inputPassword.myAddTextChangedListener {
            boolPassword = it.length > 3
            check()
        }

        inputName.myAddTextChangedListener {
            boolName = it.length > 3
            check()
        }

        buttonLogin.setOnClickListener { viewModel.userLogin(inputName.amount(), inputPassword.amount()) }
        buttonRegister.setOnClickListener { viewModel.openRegisterScreen() }
        viewModel.changeButtonStatusLiveData.observe(viewLifecycleOwner, changeButtonStatusObserver)
        viewModel.progressLiveData.observe(viewLifecycleOwner, progressObserver)
    }

    private fun check() {
        binding.buttonLogin.isEnabled = boolName && boolPassword
    }

    private val openRegisterScreenObserver = Observer<Unit> {
        viewModel.openRegisterScreenLiveData.removeObservers(this@LoginScreen)
        findNavController().navigate(R.id.action_loginScreen_to_registerScreen)
    }
    private val openContactScreenObserver = Observer<Unit> { findNavController().navigate(R.id.action_loginScreen_to_contactScreen) }
    private val notConnectionObserver = Observer<Unit> { showToast("Not connection!") }
    private val changeButtonStatusObserver = Observer<Boolean> { binding.buttonLogin.isEnabled = it }
    private val progressObserver = Observer<Boolean> { binding.progress.state(it) }
    private val errorObserver = Observer<String> { showToast(it) }
}



