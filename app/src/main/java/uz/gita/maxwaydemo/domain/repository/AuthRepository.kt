package uz.gita.maxwaydemo.domain.repository

import android.app.Activity
import uz.gita.maxwaydemo.data.model.request.RegisterRequest

interface AuthRepository {

    fun regPhoneRequest(registerRequest: RegisterRequest, code: String)

}