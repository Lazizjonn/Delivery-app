package uz.gita.maxwaydemo.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.maxwaydemo.data.model.common.CategoryDataRV
import uz.gita.maxwaydemo.data.model.response.AdsDataFromNet
import uz.gita.maxwaydemo.data.model.response.FoodDataFromNet

interface HomeViewModel {

    val adsLiveData: LiveData<List<AdsDataFromNet>>
    val categoryLiveData: LiveData<List<CategoryDataRV>>
    val errorLiveData: LiveData<String>
    val foodsLiveData: LiveData<List<FoodDataFromNet>>
    val foodsBySearchLiveData: LiveData<List<FoodDataFromNet>>
    val openPickDetailFragmentLiveData: LiveData<Unit>
    val openAdvertisementFragmentLiveData: LiveData<Unit>

    fun getAllAddsFromRepository()
    fun getAllCategoriesFromRepository(list: List<Int>)
}