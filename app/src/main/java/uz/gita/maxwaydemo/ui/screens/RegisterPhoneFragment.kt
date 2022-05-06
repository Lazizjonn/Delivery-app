package uz.gita.maxwaydemo.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.model.response.CodeTokenData
import uz.gita.maxwaydemo.databinding.FragmentRegisterPhoneBinding
import uz.gita.maxwaydemo.presentation.viewmodel.impl.RegisterPhoneViewModelImpl
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class RegisterPhoneFragment : Fragment(R.layout.fragment_register_phone) {
    private val binding by viewBinding(FragmentRegisterPhoneBinding::bind)
    private val viewModel by viewModels<RegisterPhoneViewModelImpl>()
    var phone = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        clicks()
        liveDatas()


    }




    private fun clicks() = with(binding){
        regProceed.setOnClickListener {
            // Authni tekshirish
            regPhone.text?.let {
                if (it.equals("") || it.length == 9) {
//                        viewModel.regPhoneRequest(requireActivity(), "+998" + it.toString())
                    registerFun("+998"+ it.toString())
                } else {
                    Snackbar.make(requireView(), "Enter 13 digit number", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
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
            p0.smsCode //
        }

        override fun onVerificationFailed(p0: FirebaseException) {
//            Snackbar.make(requireView(), "Verification failed", Snackbar.LENGTH_SHORT).show()

            Log.d("TAG", "Verification failed")
        }

        override fun onCodeAutoRetrievalTimeOut(p0: String) {
            // resend yoz
        }

        override fun onCodeSent(code: String, token: PhoneAuthProvider.ForceResendingToken) {
            super.onCodeSent(code, token)
            // return code and token
            Log.d("TAG", "codeListener: " + code)
            val bundle = bundleOf("phone_code" to  CodeTokenData(phone, code, token))
            findNavController().navigate(R.id.registerNameFragment, bundle)



        }
    }


    private fun liveDatas() {
        viewModel.credentialLivedata.observe(this, credentialObserver)
    }


    private val credentialObserver = Observer<CodeTokenData> { code ->

    }







}



