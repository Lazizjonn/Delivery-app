package uz.gita.maxwaydemo.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.maxwaydemo.data.model.request.RegisterRequest
import uz.gita.maxwaydemo.presentation.viewmodel.VerifyViewModel
import uz.gita.maxwaydemo.domain.usecase.VerifyUseCase
import javax.inject.Inject

@HiltViewModel
class VerifyViewModelImpl @Inject constructor(private val verifyUseCase: VerifyUseCase) : VerifyViewModel, ViewModel() {

    override val authSuccessLiveData = MutableLiveData<Boolean>()
    override val notConnectionLiveData = MutableLiveData<Boolean>()
    override val errorLiveData = MutableLiveData<String>()
    override val moveToNextScreenLiveData = MutableLiveData<Boolean>()


    override fun registerRequest(registerRequest: RegisterRequest, code: String) {
        verifyUseCase.registerRequest(registerRequest, code).onEach {
            authSuccessLiveData.value = it
            moveToNextScreenLiveData.value = it
        }.launchIn(viewModelScope)

    }




}