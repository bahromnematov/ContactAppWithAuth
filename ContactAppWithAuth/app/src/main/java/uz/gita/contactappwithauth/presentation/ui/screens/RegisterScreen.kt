package uz.gita.contactappwithauth.presentation.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.contactappwithauth.R
import uz.gita.contactappwithauth.databinding.ScreenRegisterBinding
import uz.gita.contactappwithauth.presentation.viewmodels.RegisterViewModel
import uz.gita.contactappwithauth.presentation.viewmodels.impl.RegisterViewModelImpl
import uz.gita.contactappwithauth.utils.myApply

class RegisterScreen : Fragment(R.layout.screen_register) {
    private val binding by viewBinding(ScreenRegisterBinding::bind)
    private val viewModel : RegisterViewModel by viewModels<RegisterViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.myApply {

    }
}