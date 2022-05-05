package uz.gita.maxwaydemo.usecase

import android.app.Activity
import uz.gita.maxwaydemo.data.sources.model.response.CodeTokenData


interface RegisterPhoneUseCase {

    fun regPhoneRequest(activity: Activity, phone: String)

}