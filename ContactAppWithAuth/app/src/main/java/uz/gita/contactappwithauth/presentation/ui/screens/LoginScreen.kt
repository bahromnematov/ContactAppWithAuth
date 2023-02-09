package uz.gita.contactappwithauth.presentation.ui.screens

import android.os.Bundle
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.contactappwithauth.R
import uz.gita.contactappwithauth.data.remote.requests.LoginRequest
import uz.gita.contactappwithauth.databinding.ScreenLoginBinding
import uz.gita.contactappwithauth.presentation.viewmodels.LoginViewModel
import uz.gita.contactappwithauth.presentation.viewmodels.impl.LoginViewModelImpl
import uz.gita.contactappwithauth.utils.addListener
import uz.gita.contactappwithauth.utils.myApply
import uz.gita.contactappwithauth.utils.showToast
import uz.gita.contactappwithauth.utils.values

class LoginScreen : Fragment(R.layout.screen_login) {
    private val binding by viewBinding(ScreenLoginBinding::bind)
    private val viewModel: LoginViewModel by viewModels<LoginViewModelImpl>()
    private var boolPhone = false
    private var boolPassword = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.myApply {
        inputPassword.addListener {
            boolPassword = it.length in 3 until 10
            check()
        }
        inputPhoneNumber.addListener {
            boolPhone = it.length == 13 && it.startsWith("+998")
            check()
        }

        buttonLogin.isEnabled = false
        buttonRegister.setOnClickListener { viewModel.openRegisterScreen() }
        buttonLogin.setOnClickListener {
            viewModel.loginUser(
                LoginRequest(
                    inputPhoneNumber.values(),
                    inputPassword.values()
                )
            )
        }
        viewModel.errorLiveData.observe(viewLifecycleOwner, errorObserver)
        viewModel.notConnectionLiveData.observe(viewLifecycleOwner, notConnectionObserver)
        viewModel.openContactScreenLiveData.observe(viewLifecycleOwner, openContactScreenObserver)
        viewModel.openRegisterScreenLiveData.observe(viewLifecycleOwner, openRegisterScreenObserver)
        viewModel.progressLiveData.observe(viewLifecycleOwner, progressObserver)
    }

    private fun check(){
        binding.buttonLogin.isEnabled = boolPassword && boolPhone
    }
    private val errorObserver = Observer<String> { showToast(it) }
    private val notConnectionObserver = Observer<Unit> {
        showToast("Sizda mavjud emas")
    }
    private val openContactScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_loginScreen_to_contactScreen)
    }
    private val openRegisterScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_loginScreen_to_registerScreen)
    }
    private val progressObserver = Observer<Boolean> {
        if (it) binding.progress.show()
        else binding.progress.hide()
    }
}