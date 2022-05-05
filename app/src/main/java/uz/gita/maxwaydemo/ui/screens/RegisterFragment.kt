package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.databinding.FragmentRegisterBinding
import uz.gita.maxwaydemo.presentation.viewmodel.RegisterViewModel
import uz.gita.maxwaydemo.presentation.viewmodel.impl.RegisterViewModelImpl
import javax.inject.Inject

@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.fragment_register) {

    private val viewModel: RegisterViewModel by viewModels<RegisterViewModelImpl>()

    private val binding by viewBinding(FragmentRegisterBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {


        regProceed.setOnClickListener {
           if(!regSurnameEditText.text.equals("") || regSurnameEditText.text.length > 3){
               if(!regNameEditText.text.equals("") || regNameEditText.text.length > 3){
                   // viewModel todo regEmailEditText

                   viewModel.registerRequest()
               } else {
                   Snackbar.make(requireView(), "Enter more than 3 digit name", Snackbar.LENGTH_SHORT).show()
               }
           } else {
               Snackbar.make(requireView(), "Enter more than 3 digit surname", Snackbar.LENGTH_SHORT).show()
           }


        }


        registerBtnBack.setOnClickListener {
            // viewModel
        }




    }




}