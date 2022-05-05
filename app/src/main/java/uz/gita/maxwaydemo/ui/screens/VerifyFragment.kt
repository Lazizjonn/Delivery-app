package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.databinding.FragmentVerifyBinding
import uz.gita.maxwaydemo.presentation.viewmodel.VerifyViewModel
import uz.gita.maxwaydemo.presentation.viewmodel.impl.VerifyViewModelImpl

@AndroidEntryPoint
class VerifyFragment : Fragment(R.layout.fragment_verify) {
    private val binding by viewBinding(FragmentVerifyBinding::bind)
    private val navAgrs by navArgs<VerifyFragmentArgs>()
    private val viewModel: VerifyViewModel by viewModels<VerifyViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        clicks()

    }

    private fun clicks() = with(binding){

        registerBtnBack.setOnClickListener {

        }


        regProceed.setOnClickListener {
            val code = pinEditText.text.toString()
            if(!code.isEmpty() && code.length == 6) {
                viewModel.registerRequest(navAgrs.regData, code)
            }

        }
    }


}