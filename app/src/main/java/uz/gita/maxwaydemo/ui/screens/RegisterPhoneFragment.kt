package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.app.App
import uz.gita.maxwaydemo.data.sources.model.response.CodeTokenData
import uz.gita.maxwaydemo.databinding.FragmentRegisterPhoneBinding
import uz.gita.maxwaydemo.presentation.viewmodel.impl.RegisterPhoneViewModelImpl
import javax.inject.Inject

@AndroidEntryPoint
class RegisterPhoneFragment : Fragment(R.layout.fragment_register_phone) {
    private val binding by viewBinding(FragmentRegisterPhoneBinding::bind)
    private val viewModel by viewModels<RegisterPhoneViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding){

        regProceed.setOnClickListener {
            if (App.userData.name == null) {
                regPhone.text?.let {
                    if (it.equals("") || it.length == 9) {
                        viewModel.regPhoneRequest(requireActivity(), "+998" + it.toString())
                    } else {
                        Snackbar.make(requireView(), "Enter 13 digit number", Snackbar.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }



        liveDatas()
    }

    private fun liveDatas() {
        viewModel.credentialLivedata.observe(this, credentialObserver)
    }


    private val credentialObserver = Observer<CodeTokenData> { code ->
        binding.regPhone.text?.let {
            if(it.equals("") || it.length == 9 ){
                val phone = "+998"+ it.toString()
                findNavController().navigate(
                    RegisterPhoneFragmentDirections.actionRegisterPhoneFragmentToRegisterNameFragment(phone, code))
            } else {
                Snackbar.make(requireView(), "Phone number conflict", Snackbar.LENGTH_SHORT).show()
            }
        }


    }





}



