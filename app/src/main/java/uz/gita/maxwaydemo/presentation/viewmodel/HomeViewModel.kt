package uz.gita.maxwaydemo.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.maxwaydemo.data.sources.model.common.CategoryDataRV
import uz.gita.maxwaydemo.data.sources.model.response.AdsDataFromNet
import uz.gita.maxwaydemo.data.sources.model.response.FoodDataFromNet

interface HomeViewModel {

    val adsLiveData: LiveData<List<AdsDataFromNet>>
    val categoryLiveData: LiveData<List<CategoryDataRV>>
    val errorLiveData: LiveData<String>
//    val foodsLiveData: LiveData<Pair<List<List<FoodDataFromNet>>, List<CategoryDataFromNet>>>
    val foodsLiveData: LiveData<List<FoodDataFromNet>>
    val foodsBySearchLiveData: LiveData<List<FoodDataFromNet>>

    val openPickDetailFragmentLiveData: LiveData<Unit>
    val openAdvertisementFragmentLiveData: LiveData<Unit>

    fun loadImagesFromFirebase(): ArrayList<Int>

    fun getAllAddsFromRepository()
    fun getAllCategoriesFromRepository()
    fun getAllFoodsFromRepository()

}