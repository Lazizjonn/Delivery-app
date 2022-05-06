package uz.gita.maxwaydemo.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.maxwaydemo.data.model.request.RegisterRequest

interface VerifyViewModel {

    val authSuccessLiveData: LiveData<Boolean>
    val notConnectionLiveData: LiveData<Boolean>
    val errorLiveData: LiveData<String>
    val moveToNextScreenLiveData: LiveData<Boolean>

    fun registerRequest(registerRequest: RegisterRequest, code: String)


}