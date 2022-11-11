package uz.gita.maxwaydemo.domain.usecase.impl

import uz.gita.maxwaydemo.data.model.request.RegisterRequest
import uz.gita.maxwaydemo.domain.repository.AuthRepository
import uz.gita.maxwaydemo.domain.usecase.RegisterUseCase
import javax.inject.Inject

class RegisterUseCaseImpl @Inject constructor(
    private val repository: AuthRepository
): RegisterUseCase {


    override fun registerRequest(registerRequest: RegisterRequest) {

    }
}