package uz.gita.maxwaydemo.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.sources.local.MySharedPref
import uz.gita.maxwaydemo.data.sources.local.common.IntroData
import uz.gita.maxwaydemo.domain.repository.AppRepository
import uz.gita.maxwaydemo.presentation.viewmodel.IntroViewModel
import javax.inject.Inject

@HiltViewModel
class IntroViewModelImpl @Inject constructor(
    private val repository: AppRepository,
    private val pref: MySharedPref
) : ViewModel(), IntroViewModel {

    override val openHomeFragmentLiveData = MutableLiveData<Unit>()

    override fun clickedEnterOrSkip() {
        pref.isNotFirstTime = true
        openHomeFragmentLiveData.value = Unit
    }

    override fun setData(): MutableList<IntroData> {
        return repository.setData()

    }
}