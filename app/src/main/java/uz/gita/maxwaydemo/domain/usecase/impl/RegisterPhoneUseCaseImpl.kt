package uz.gita.maxwaydemo.domain.usecase.impl

import android.app.Activity
import uz.gita.maxwaydemo.domain.repository.AuthRepository
import uz.gita.maxwaydemo.domain.usecase.RegisterPhoneUseCase
import javax.inject.Inject


class RegisterPhoneUseCaseImpl @Inject constructor(private val authRepository: AuthRepository)
    : RegisterPhoneUseCase {




    override fun regPhoneRequest(activity: Activity, phone: String){
        /*val result = authRepository.regPhoneRequest(activity,phone)*/

    }




}