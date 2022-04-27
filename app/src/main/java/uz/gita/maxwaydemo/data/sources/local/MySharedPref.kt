package uz.gita.maxwaydemo.data.sources.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MySharedPref @Inject constructor(@ApplicationContext context: Context) {

    private val pref = context.getSharedPreferences("delivery", Context.MODE_PRIVATE)


}