package uz.gita.maxwaydemo.domain.repository

import android.app.Activity
import kotlinx.coroutines.flow.Flow
import uz.gita.maxwaydemo.data.model.request.RegisterRequest

interface AuthRepository {

    fun regPhoneRequest(registerRequest: RegisterRequest, code: String): Flow<Boolean>

}