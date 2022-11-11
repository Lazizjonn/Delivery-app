package uz.gita.maxwaydemo.domain.usecase

import android.app.Activity


interface RegisterPhoneUseCase {

    fun regPhoneRequest(activity: Activity, phone: String)

}