package uz.gita.maxwaydemo.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.maxwaydemo.domain.repository.AppRepository
import uz.gita.maxwaydemo.domain.repository.impl.AppRepositoryImpl
import javax.inject.Singleton


@[Module InstallIn(SingletonComponent::class)]
interface AppRepositoryModule {

    @[Singleton Binds]
    fun getAppRepository(impl: AppRepositoryImpl): AppRepository
}