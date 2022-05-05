package uz.gita.maxwaydemo.presentation.viewmodel.impl

import android.app.Activity
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.maxwaydemo.data.sources.model.response.CodeTokenData
import uz.gita.maxwaydemo.domain.repository.AuthRepository
import uz.gita.maxwaydemo.domain.repository.impl.AuthRepositoryImpl
import uz.gita.maxwaydemo.presentation.viewmodel.RegisterPhoneViewModel
import uz.gita.maxwaydemo.usecase.RegisterPhoneUseCase
import uz.gita.maxwaydemo.usecase.impl.RegisterPhoneUseCaseImpl
import javax.inject.Inject

@HiltViewModel
class RegisterPhoneViewModelImpl @Inject constructor(
    private val regPhone: RegisterPhoneUseCase,
    private val authRepository: AuthRepositoryImpl
) : RegisterPhoneViewModel, ViewModel() {

    override val credentialLivedata = MutableLiveData<CodeTokenData>()

    init {

    }

    override fun regPhoneRequest(activity: Activity, phone: String) {
        regPhone.regPhoneRequest(activity, phone)
    }




}