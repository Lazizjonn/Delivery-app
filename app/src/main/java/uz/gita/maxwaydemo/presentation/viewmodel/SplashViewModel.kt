package uz.gita.maxwaydemo.presentation.viewmodel

import androidx.lifecycle.LiveData

interface SplashViewModel {
    val openIntroFragmentLiveData: LiveData<Unit>
    val openHomeFragmentLiveData: LiveData<Unit>
}