package uz.gita.maxwaydemo.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import uz.gita.maxwaydemo.data.model.common.UserData

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        userData = UserData(0)
    }

    companion object {
        lateinit var userData: UserData
        lateinit var instance: App
            private set
    } //
    //
}