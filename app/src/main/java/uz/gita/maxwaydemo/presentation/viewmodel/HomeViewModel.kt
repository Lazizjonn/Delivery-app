package uz.gita.maxwaydemo.presentation.viewmodel

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import uz.gita.maxwaydemo.data.sources.local.model.response.FoodDataFromNet

interface HomeViewModel {

    val openPickDetailFragmentLiveData: LiveData<Unit>
    val openAdvertisementFragmentLiveData: LiveData<Unit>

    fun loadImagesFromFirebase(): ArrayList<Int>

}