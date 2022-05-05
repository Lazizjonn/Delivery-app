package uz.gita.maxwaydemo.domain.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import uz.gita.maxwaydemo.data.model.common.CategoryDataRV
import uz.gita.maxwaydemo.data.model.common.IntroData
import uz.gita.maxwaydemo.data.model.response.AdsDataFromNet

interface MealRepository {

    fun setDataForIntroFragment(): MutableList<IntroData>

    fun loadImagesFromFirebase(): ArrayList<Int>


    fun getAllAddsPhotosFromFirebase(): Flow<Result<List<AdsDataFromNet>>>
//    fun getAllCategoriesPhotosFromFirebase(): Flow<Result<List<CategoryDataFromNet>>>
//    fun getAllFoodsPhotosFromFirebase(): Flow<Result<List<FoodDataFromNet>>>

    fun getAllCategoriesForRV(scope: CoroutineScope): Flow<Result<List<CategoryDataRV>>>
}