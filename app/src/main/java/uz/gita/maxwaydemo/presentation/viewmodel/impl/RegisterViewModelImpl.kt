package uz.gita.maxwaydemo.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.maxwaydemo.data.model.request.RegisterRequest
import uz.gita.maxwaydemo.presentation.viewmodel.RegisterViewModel
import uz.gita.maxwaydemo.usecase.RegisterUseCase
import javax.inject.Inject

@HiltViewModel
class RegisterViewModelImpl @Inject constructor(
    private val useCase: RegisterUseCase
) : RegisterViewModel, ViewModel() {


    override fun registerRequest(registerRequest: RegisterRequest) {
        useCase.registerRequest(registerRequest)

    }

}