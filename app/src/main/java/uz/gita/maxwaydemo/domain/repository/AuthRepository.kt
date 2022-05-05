package uz.gita.maxwaydemo.domain.repository

import android.app.Activity

interface AuthRepository {

    fun regPhoneRequest(activity: Activity, phone: String)

}