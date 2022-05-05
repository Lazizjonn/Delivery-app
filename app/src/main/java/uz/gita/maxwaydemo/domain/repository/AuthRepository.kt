package uz.gita.maxwaydemo.domain.repository

import android.app.Activity
import androidx.lifecycle.LiveData
import uz.gita.maxwaydemo.data.sources.model.response.CodeTokenData

interface AuthRepository {

    fun regPhoneRequest(activity: Activity, phone: String)

}