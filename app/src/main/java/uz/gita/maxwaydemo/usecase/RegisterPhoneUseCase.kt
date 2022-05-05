package uz.gita.maxwaydemo.usecase

import android.app.Activity


interface RegisterPhoneUseCase {

    fun regPhoneRequest(activity: Activity, phone: String)

}