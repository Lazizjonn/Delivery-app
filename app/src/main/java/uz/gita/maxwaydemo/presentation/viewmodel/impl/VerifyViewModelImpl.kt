package uz.gita.maxwaydemo.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.maxwaydemo.data.model.request.RegisterRequest
import uz.gita.maxwaydemo.presentation.viewmodel.VerifyViewModel
import uz.gita.maxwaydemo.usecase.VerifyUseCase
import javax.inject.Inject

@HiltViewModel
class VerifyViewModelImpl @Inject constructor(private val verifyUseCase: VerifyUseCase) : VerifyViewModel, ViewModel() {

    override fun registerRequest(registerRequest: RegisterRequest, code: String) {
        verifyUseCase.registerRequest(registerRequest, code)
    }

}