package uz.gita.maxwaydemo.domain.repository

import uz.gita.maxwaydemo.data.sources.local.common.IntroData

interface AppRepository {

    fun setData(): MutableList<IntroData>
}