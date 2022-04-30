package uz.gita.maxwaydemo.domain.repository.impl

import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.sources.local.common.IntroData
import uz.gita.maxwaydemo.domain.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor() : AppRepository {

    override fun setData(): MutableList<IntroData> {
        val list: MutableList<IntroData> = ArrayList()
        list.add(IntroData(R.color.white, R.drawable.group_1))
        list.add(IntroData(R.color.white, R.drawable.group_2))
        list.add(IntroData(R.color.white, R.drawable.group_3))
        list.add(IntroData(R.color.white, R.drawable.group_4))
        return list
    }
}