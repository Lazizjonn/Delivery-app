package uz.gita.maxwaydemo.data.sources.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MySharedPref @Inject constructor(@ApplicationContext context: Context) {

    private val pref = context.getSharedPreferences("delivery", Context.MODE_PRIVATE)

    var isNotFirstTime: Boolean
        get() = pref!!.getBoolean("INTRO", false)
        set(value) = pref!!.edit().putBoolean("INTRO", value).apply()

}
