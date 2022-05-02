package uz.gita.maxwaydemo.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.maxwaydemo.domain.repository.AppRepository
import uz.gita.maxwaydemo.presentation.viewmodel.HomeViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl @Inject constructor(
    private val repository: AppRepository
) : HomeViewModel, ViewModel() {

    override val openPickDetailFragmentLiveData = MutableLiveData<Unit>()
    override val openAdvertisementFragmentLiveData = MutableLiveData<Unit>()

    override fun loadImagesFromFirebase(): ArrayList<Int> {
        return repository.loadImagesFromFirebase()
    }


}