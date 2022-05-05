package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.rpc.Code
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.app.App
import uz.gita.maxwaydemo.data.sources.model.response.CodeTokenData
import uz.gita.maxwaydemo.databinding.FragmentRegisterPhoneBinding
import uz.gita.maxwaydemo.presentation.viewmodel.impl.RegisterPhoneViewModelImpl
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class RegisterPhoneFragment : Fragment(R.layout.fragment_register_phone) {
    private val binding by viewBinding(FragmentRegisterPhoneBinding::bind)
    private val viewModel by viewModels<RegisterPhoneViewModelImpl>()
    var phone = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding){

        regProceed.setOnClickListener {
            if (App.userData.name == null) {  // tekshirish
                regPhone.text?.let {
                    if (it.equals("") || it.length == 9) {
//                        viewModel.regPhoneRequest(requireActivity(), "+998" + it.toString())
                        registerFun("+998"+ it.toString())
                    } else {
                        Snackbar.make(requireView(), "Enter 13 digit number", Snackbar.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }


        liveDatas()
    }

    private fun registerFun(phone: String) {
        this.phone = phone

        val option = PhoneAuthOptions.newBuilder()
            .setActivity(requireActivity())
            .setTimeout(10, TimeUnit.SECONDS)
            .setPhoneNumber(phone)
            .setCallbacks(regPhoneCallBack)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(option)


    }

    val regPhoneCallBack = object: PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
        override fun onVerificationCompleted(p0: PhoneAuthCredential) {
            p0.smsCode
        }

        override fun onVerificationFailed(p0: FirebaseException) {
            Snackbar.make(requireView(), "Verification failed", Snackbar.LENGTH_SHORT).show()
        }

        override fun onCodeAutoRetrievalTimeOut(p0: String) {
            // resend yoz
        }

        override fun onCodeSent(code: String, token: PhoneAuthProvider.ForceResendingToken) {
            super.onCodeSent(code, token)
            // return code and token
            Log.d("TAG", "codeListener: " + code)
//            findNavController().navigate(RegisterPhoneFragmentDirections.actionRegisterPhoneFragmentToRegisterNameFragment(phone, CodeTokenData(code, token)))

        }
    }


    private fun liveDatas() {
        viewModel.credentialLivedata.observe(this, credentialObserver)
    }


    private val credentialObserver = Observer<CodeTokenData> { code ->

    }







}



