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




    override fun regPhoneRequest(activity: Activity, phone: String) {

    }




}