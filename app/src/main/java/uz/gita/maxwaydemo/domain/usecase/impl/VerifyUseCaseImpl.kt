package uz.gita.maxwaydemo.domain.usecase.impl

import uz.gita.maxwaydemo.data.model.request.RegisterRequest
import uz.gita.maxwaydemo.domain.repository.AuthRepository
import uz.gita.maxwaydemo.domain.usecase.VerifyUseCase
import javax.inject.Inject

class VerifyUseCaseImpl @Inject constructor(private val authRepository: AuthRepository): VerifyUseCase {

    override fun registerRequest(registerRequest: RegisterRequest, code: String) = authRepository.regPhoneRequest(registerRequest, code)
}