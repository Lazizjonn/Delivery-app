package uz.gita.maxwaydemo.domain.usecase

import uz.gita.maxwaydemo.data.model.request.RegisterRequest

interface RegisterUseCase {

    fun registerRequest(registerRequest: RegisterRequest)
}