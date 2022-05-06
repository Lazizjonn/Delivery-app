package uz.gita.maxwaydemo.data.model.response

import com.google.firebase.auth.PhoneAuthProvider
import java.io.Serializable

data class CodeTokenData(
    val phone: String,
    val code: String,
    val token: PhoneAuthProvider.ForceResendingToken
): Serializable
