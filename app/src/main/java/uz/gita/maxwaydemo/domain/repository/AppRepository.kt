package uz.gita.maxwaydemo.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.maxwaydemo.data.sources.local.model.common.IntroData
import uz.gita.maxwaydemo.data.sources.local.model.response.AdsDataFromNet
import uz.gita.maxwaydemo.data.sources.local.model.response.CategoryDataFromNet

interface AppRepository {

    fun setDataForIntroFragment(): MutableList<IntroData>

    fun loadImagesFromFirebase(): ArrayList<Int>


    fun getAllAddsPhotosFromFirebase(): Flow<Result<List<AdsDataFromNet>>>
    fun getAllCategoriesPhotosFromFirebase(): Flow<Result<List<CategoryDataFromNet>>>
    fun getAllFoodsPhotosFromFirebase(): ArrayList<Int>
    fun getAllShaurmaPhotosFromFirebase(): ArrayList<Int>
}