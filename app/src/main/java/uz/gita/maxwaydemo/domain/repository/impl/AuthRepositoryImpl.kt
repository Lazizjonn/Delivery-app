package uz.gita.maxwaydemo.domain.repository.impl

import android.app.Activity
import android.util.Log
import androidx.lifecycle.LiveData
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.flow.channelFlow
import uz.gita.maxwaydemo.data.sources.model.response.CodeTokenData
import uz.gita.maxwaydemo.domain.repository.AuthRepository
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepository {


    private var codeTokenData: CodeTokenData? = null

    private var smsCodeListener: ((Unit)-> Unit)? = null
    fun setSmsCodeListener(block: (Unit)-> Unit){
        this.smsCodeListener = block
    }




    override fun regPhoneRequest(activity: Activity, phone: String) {

        val option = PhoneAuthOptions.newBuilder()
            .setActivity(activity)
            .setTimeout(10, TimeUnit.SECONDS)
            .setPhoneNumber(phone)
            .setCallbacks(regPhoneCallBack)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(option)
    }

    override fun getCredentials(): CodeTokenData? {
        return when(codeTokenData){
            null -> null
            else -> codeTokenData
        }
    }

    val regPhoneCallBack = object: PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
        override fun onVerificationCompleted(p0: PhoneAuthCredential) {
            p0.smsCode
        }

        override fun onVerificationFailed(p0: FirebaseException) {
            // failed todo
        }

        override fun onCodeAutoRetrievalTimeOut(p0: String) {
            // resend yoz
        }

        override fun onCodeSent(code: String, token: PhoneAuthProvider.ForceResendingToken) {
            super.onCodeSent(code, token)
            // return code and token
            codeTokenData = CodeTokenData(code, token)
            Log.d("TAG", "codeListener: " + code)
            smsCodeListener?.invoke(Unit)
        }
    }




}