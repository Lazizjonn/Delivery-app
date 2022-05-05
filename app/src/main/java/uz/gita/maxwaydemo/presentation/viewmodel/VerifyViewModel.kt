package uz.gita.maxwaydemo.presentation.viewmodel

import uz.gita.maxwaydemo.data.model.request.RegisterRequest

interface VerifyViewModel {

    fun registerRequest(registerRequest: RegisterRequest, code: String)
}