package uz.gita.maxwaydemo.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.maxwaydemo.data.model.common.CategoryDataRV
import uz.gita.maxwaydemo.data.model.response.AdsDataFromNet
import uz.gita.maxwaydemo.data.model.response.FoodDataFromNet
import uz.gita.maxwaydemo.domain.repository.MealRepository
import uz.gita.maxwaydemo.presentation.viewmodel.HomeViewModel
import uz.gita.maxwaydemo.usecase.HomeUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl @Inject constructor(
    private val repository: MealRepository,
    private val useCase: HomeUseCase
) : HomeViewModel, ViewModel() {

    override val adsLiveData = MutableLiveData<List<AdsDataFromNet>>()
    override val categoryLiveData = MutableLiveData<List<CategoryDataRV>>()
    override val foodsLiveData = MutableLiveData<List<FoodDataFromNet>>()
    override val foodsBySearchLiveData = MutableLiveData<List<FoodDataFromNet>>()
    override val errorLiveData = MutableLiveData<String>()
    override val openPickDetailFragmentLiveData = MutableLiveData<Unit>()
    override val openAdvertisementFragmentLiveData = MutableLiveData<Unit>()
    private val list: ArrayList<Int> = arrayListOf(1,2,3,4,5)

    init {
        getAllAddsFromRepository()
        getAllCategoriesFromRepository()
        getAllCategoriesBySelected(list)
    }

    override fun getAllAddsFromRepository() {
        repository.getAllAddsPhotosFromFirebase().onEach { it ->
            it.onSuccess { adsLiveData.value = it }
                .onFailure { errorLiveData.value = it.message }
        }.launchIn(viewModelScope)
    }

    override fun getAllCategoriesFromRepository() {
        repository.getAllCategoriesForRV(viewModelScope).onEach { it ->
            it.onSuccess {
                categoryLiveData.value = it
            }
                .onFailure { errorLiveData.value = it.message }
        }.launchIn(viewModelScope)
    }

    override fun getAllCategoriesBySelected(list: List<Int>) {
        useCase.getAllCategoriesBySelected(viewModelScope, list).onEach {
            it.onSuccess { }
                .onFailure { }

        }.launchIn(viewModelScope)
    }

}