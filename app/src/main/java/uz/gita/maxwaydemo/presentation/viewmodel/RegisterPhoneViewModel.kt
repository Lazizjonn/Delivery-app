package uz.gita.maxwaydemo.presentation.viewmodel

import android.app.Activity
import androidx.lifecycle.LiveData
import uz.gita.maxwaydemo.data.model.response.CodeTokenData

interface RegisterPhoneViewModel {
    val credentialLivedata: LiveData<CodeTokenData>

    fun regPhoneRequest(activity: Activity, phone: String)
}
