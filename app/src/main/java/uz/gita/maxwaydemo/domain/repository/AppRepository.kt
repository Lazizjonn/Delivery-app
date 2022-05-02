package uz.gita.maxwaydemo.domain.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import uz.gita.maxwaydemo.data.sources.local.model.common.CategoryDataRV
import uz.gita.maxwaydemo.data.sources.local.model.common.IntroData
import uz.gita.maxwaydemo.data.sources.local.model.response.AdsDataFromNet
import uz.gita.maxwaydemo.data.sources.local.model.response.CategoryDataFromNet
import uz.gita.maxwaydemo.data.sources.local.model.response.FoodDataFromNet

interface AppRepository {

    fun setDataForIntroFragment(): MutableList<IntroData>

    fun loadImagesFromFirebase(): ArrayList<Int>


    fun getAllAddsPhotosFromFirebase(): Flow<Result<List<AdsDataFromNet>>>
//    fun getAllCategoriesPhotosFromFirebase(): Flow<Result<List<CategoryDataFromNet>>>
//    fun getAllFoodsPhotosFromFirebase(): Flow<Result<List<FoodDataFromNet>>>

    fun getAllCategoriesForRV(scope: CoroutineScope): Flow<Result<List<CategoryDataRV>>>
}