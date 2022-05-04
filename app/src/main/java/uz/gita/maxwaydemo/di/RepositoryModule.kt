package uz.gita.maxwaydemo.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.maxwaydemo.domain.repository.AuthRepository
import uz.gita.maxwaydemo.domain.repository.MealRepository
import uz.gita.maxwaydemo.domain.repository.impl.AuthRepositoryImpl
import uz.gita.maxwaydemo.domain.repository.impl.MealRepositoryImpl
import javax.inject.Singleton


@[Module InstallIn(SingletonComponent::class)]
interface RepositoryModule {

    @[Singleton Binds]
    fun getMealRepository(impl: MealRepositoryImpl): MealRepository

    @[Singleton Binds]
    fun getAuthRepository(impl: AuthRepositoryImpl): AuthRepository
}