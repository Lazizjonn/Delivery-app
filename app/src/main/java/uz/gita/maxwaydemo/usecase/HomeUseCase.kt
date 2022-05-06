package uz.gita.maxwaydemo.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import uz.gita.maxwaydemo.data.model.common.CategoryDataRV

interface HomeUseCase {

    fun getAllCategoriesBySelected (scope: CoroutineScope, list: List<Int>) : Flow<Result<List<CategoryDataRV>>>

}