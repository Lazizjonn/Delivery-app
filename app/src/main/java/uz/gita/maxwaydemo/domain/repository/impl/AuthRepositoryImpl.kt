package uz.gita.maxwaydemo.domain.repository.impl

import android.util.Log
import android.app.Activity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import uz.gita.maxwaydemo.app.App
import uz.gita.maxwaydemo.data.model.request.RegisterRequest
import uz.gita.maxwaydemo.data.sources.local.mySharedPref.MySharedPref
import uz.gita.maxwaydemo.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val pref: MySharedPref
) : AuthRepository {


    override fun regPhoneRequest(registerRequest: RegisterRequest, code: String) {
        val credential = PhoneAuthProvider.getCredential(registerRequest.code!!, code)
        signInWithPhoneAuthCredential(credential, registerRequest)
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential, registerRequest: RegisterRequest) {
        auth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                Log.d("TAG", "signInWithCredential:success")
                val user = it.result?.user
                App.myUser.id = user?.uid.toString()
                App.myUser.name = registerRequest.name
                App.myUser.surname = registerRequest.surname
                App.myUser.phone = registerRequest.phone
                App.myUser.email = registerRequest.email

                Log.d("TAG", "repository prepared : " + user.toString())
                pref.putUser(App.myUser, "user")
                Log.d("TAG", "repository pref set : " + user.toString())
                pref.getUser("user")
                Log.d("TAG", "repository pref get: " + user.toString())



            } else {
                // Sign in failed, display a message and update the UI
                Log.w("TAG", "signInWithCredential:failure", it.exception)
                if (it.exception is FirebaseAuthInvalidCredentialsException) {
                    // The verification code entered was invalid
                }
                // Update UI
            }
        }
    }



}