package uz.gita.maxwaydemo.domain.repository.impl

import android.app.Activity
import com.google.firebase.auth.FirebaseAuth
import uz.gita.maxwaydemo.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepository {




    override fun regPhoneRequest(activity: Activity, phone: String) {

    }




}