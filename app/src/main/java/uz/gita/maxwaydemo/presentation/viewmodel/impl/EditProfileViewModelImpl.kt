package uz.gita.maxwaydemo.presentation.viewmodel.impl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.maxwaydemo.app.App
import uz.gita.maxwaydemo.data.sources.local.mySharedPref.MySharedPref
import uz.gita.maxwaydemo.presentation.viewmodel.EditProfileViewModel
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModelImpl @Inject constructor(
    private var pref: MySharedPref): EditProfileViewModel, ViewModel() {



    override val signInUserLiveData = MutableLiveData<Unit>()

    override fun checkUser() {
        App.initUser(pref)
        if (App.myUser == null){

            Log.d("TAG", "checkUser: null " + App.myUser.toString())
            signInUserLiveData.value = Unit
        }
        else{
            Log.d("TAG", "checkUser: notNull" + App.myUser.toString())
        }

    }

}