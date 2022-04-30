package uz.gita.maxwaydemo.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.maxwaydemo.data.sources.local.MySharedPref
import uz.gita.maxwaydemo.presentation.viewmodel.SplashViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val pref: MySharedPref
) : SplashViewModel, ViewModel() {

    override val openIntroFragmentLiveData = MutableLiveData<Unit>()
    override val openHomeFragmentLiveData = MutableLiveData<Unit>()

    init {
        viewModelScope.launch {
            delay(2000)
            if (pref.isNotFirstTime) {
                openHomeFragmentLiveData.postValue(Unit)
            } else {
                openIntroFragmentLiveData.postValue(Unit)
            }
        }
    }
}