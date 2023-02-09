package uz.gita.contactappwithauth.presentation.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.contactappwithauth.R
import uz.gita.contactappwithauth.databinding.ScreenCodeVerifyBinding
import uz.gita.contactappwithauth.presentation.viewmodels.CodeVerifyViewModel
import uz.gita.contactappwithauth.presentation.viewmodels.impl.CodeVerifyViewModelImpl
import uz.gita.contactappwithauth.utils.myApply

class CodeVerifyScreen : Fragment(R.layout.screen_code_verify){
    private val binding by viewBinding(ScreenCodeVerifyBinding::bind)
    private val viewModel : CodeVerifyViewModel by viewModels<CodeVerifyViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.myApply {

    }
}

