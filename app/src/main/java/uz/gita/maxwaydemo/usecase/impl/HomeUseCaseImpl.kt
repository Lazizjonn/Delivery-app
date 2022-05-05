package uz.gita.maxwaydemo.usecase.impl

import uz.gita.maxwaydemo.domain.repository.MealRepository
import uz.gita.maxwaydemo.usecase.HomeUseCase
import javax.inject.Inject

class HomeUseCaseImpl @Inject constructor(
    private val mealRepository: MealRepository
) : HomeUseCase {

}