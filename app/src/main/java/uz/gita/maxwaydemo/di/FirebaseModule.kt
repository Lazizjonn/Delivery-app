package uz.gita.maxwaydemo.di

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
class FirebaseModule {

    @[Provides Singleton]
    fun getRealTimeDataBase(): FirebaseDatabase = Firebase.database

    @[Provides Singleton]
    fun getDeliveryReference(database: FirebaseDatabase): DatabaseReference = database.getReference("delivery")

}