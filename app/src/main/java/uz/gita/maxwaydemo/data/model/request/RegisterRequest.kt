package uz.gita.maxwaydemo.data.model.request

import com.google.firebase.auth.PhoneAuthProvider
import uz.gita.maxwaydemo.ui.screens.RegisterPhoneFragment
import java.io.Serializable

data class RegisterRequest(
    val name: String,
    val surname: String,
    val phone: String,
    val email: String? = null,
    val code: String,
    val token: PhoneAuthProvider.ForceResendingToken
): Serializable
