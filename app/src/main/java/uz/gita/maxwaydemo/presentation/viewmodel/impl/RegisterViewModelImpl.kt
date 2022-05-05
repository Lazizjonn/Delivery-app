package uz.gita.maxwaydemo.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.maxwaydemo.presentation.viewmodel.RegisterViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModelImpl @Inject constructor() : RegisterViewModel, ViewModel() {


    override fun registerRequest() {

    }

}