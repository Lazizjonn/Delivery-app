package uz.gita.maxwaydemo.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.maxwaydemo.data.sources.local.model.common.IntroData
import uz.gita.maxwaydemo.data.sources.local.model.response.AdsData
import uz.gita.maxwaydemo.data.sources.local.model.response.CategoryDataFromFirebase

interface AppRepository {

    fun setDataForIntroFragment(): MutableList<IntroData>

    fun loadImagesFromFirebase(): ArrayList<Int>


    fun getAllAddsPhotosFromFirebase(): Flow<Result<List<AdsData>>>
    fun getAllCategoriesPhotosFromFirebase(): Flow<Result<List<CategoryDataFromFirebase>>>
    fun getAllFoodsPhotosFromFirebase(): ArrayList<Int>
    fun getAllShaurmaPhotosFromFirebase(): ArrayList<Int>
}