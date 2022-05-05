package uz.gita.maxwaydemo.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.maxwaydemo.data.model.common.IntroData

interface IntroViewModel {

    val openHomeFragmentLiveData: LiveData<Unit>

    fun clickedEnterOrSkip ()

    fun setDataForIntroFragment(): MutableList<IntroData>

}