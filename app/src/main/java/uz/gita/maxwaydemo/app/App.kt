package uz.gita.maxwaydemo.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import uz.gita.maxwaydemo.data.model.common.MyUser
import uz.gita.maxwaydemo.data.model.common.UserData

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        myUser = MyUser("0", "", "", "")
    }

    companion object {
        lateinit var myUser: MyUser
        lateinit var instance: App
            private set
    } //
    //
}