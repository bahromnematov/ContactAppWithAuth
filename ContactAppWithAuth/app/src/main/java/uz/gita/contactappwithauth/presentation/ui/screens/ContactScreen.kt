package uz.gita.contactappwithauth.presentation.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.contactappwithauth.R
import uz.gita.contactappwithauth.databinding.ScreenContactBinding
import uz.gita.contactappwithauth.presentation.viewmodels.ContactViewModel
import uz.gita.contactappwithauth.presentation.viewmodels.impl.ContactViewModelImpl
import uz.gita.contactappwithauth.utils.myApply

class ContactScreen : Fragment(R.layout.screen_contact) {
    private val binding by viewBinding(ScreenContactBinding::bind)
    private val viewModel : ContactViewModel by viewModels<ContactViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.myApply {

    }
}