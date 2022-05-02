package uz.gita.maxwaydemo.presentation.viewmodel

import androidx.lifecycle.LiveData

interface HomeViewModel {

    val openPickDetailFragmentLiveData: LiveData<Unit>
    val openAdvertisementFragmentLiveData: LiveData<Unit>

    fun loadImagesFromFirebase(): ArrayList<Int>

}