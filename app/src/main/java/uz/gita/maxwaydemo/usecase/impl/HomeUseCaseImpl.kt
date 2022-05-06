package uz.gita.maxwaydemo.usecase.impl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import uz.gita.maxwaydemo.data.model.common.CategoryDataRV
import uz.gita.maxwaydemo.domain.repository.MealRepository
import uz.gita.maxwaydemo.usecase.HomeUseCase
import javax.inject.Inject

class HomeUseCaseImpl @Inject constructor(
    private val mealRepository: MealRepository
) : HomeUseCase {
    override fun getAllCategoriesBySelected(scope: CoroutineScope, list: List<Int>): Flow<Result<List<CategoryDataRV>>> {
        return mealRepository.getAllCategoriesBySelected(scope, list)
    }

}