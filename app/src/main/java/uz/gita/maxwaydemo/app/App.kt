package uz.gita.maxwaydemo.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import uz.gita.maxwaydemo.data.model.common.MyUser
import uz.gita.maxwaydemo.data.sources.local.mySharedPref.MySharedPref
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


    companion object {
        var myUser: MyUser? = null
        lateinit var instance: App
            private set

        fun initUser(pref: MySharedPref){
            myUser = pref.getUser("user")
        }
    }
    //
}