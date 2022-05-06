package uz.gita.maxwaydemo.presentation.viewmodel

import androidx.lifecycle.LiveData

interface EditProfileViewModel {

    val signInUserLiveData: LiveData<Unit>

    fun checkUser()
}