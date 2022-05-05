package uz.gita.maxwaydemo.usecase.impl

import android.app.Activity
import uz.gita.maxwaydemo.data.sources.model.response.CodeTokenData
import uz.gita.maxwaydemo.domain.repository.AuthRepository
import uz.gita.maxwaydemo.usecase.RegisterPhoneUseCase
import javax.inject.Inject


class RegisterPhoneUseCaseImpl @Inject constructor(private val authRepository: AuthRepository)
    : RegisterPhoneUseCase {




    override fun regPhoneRequest(activity: Activity, phone: String){
        /*val result = authRepository.regPhoneRequest(activity,phone)*/

    }




}