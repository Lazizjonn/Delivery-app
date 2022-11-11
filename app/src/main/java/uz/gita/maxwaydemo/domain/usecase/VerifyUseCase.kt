package uz.gita.maxwaydemo.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.maxwaydemo.data.model.request.RegisterRequest

interface VerifyUseCase {

    fun registerRequest(registerRequest: RegisterRequest, code: String): Flow<Boolean>
}