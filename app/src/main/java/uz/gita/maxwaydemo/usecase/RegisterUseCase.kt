package uz.gita.maxwaydemo.usecase

import uz.gita.maxwaydemo.data.model.request.RegisterRequest

interface RegisterUseCase {

    fun registerRequest(registerRequest: RegisterRequest)
}