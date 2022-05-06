package uz.gita.maxwaydemo.usecase.impl

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.maxwaydemo.data.model.request.RegisterRequest
import uz.gita.maxwaydemo.domain.repository.AuthRepository
import uz.gita.maxwaydemo.usecase.VerifyUseCase
import javax.inject.Inject

class VerifyUseCaseImpl @Inject constructor(private val authRepository: AuthRepository): VerifyUseCase {

    override fun registerRequest(registerRequest: RegisterRequest, code: String) = authRepository.regPhoneRequest(registerRequest, code)
}