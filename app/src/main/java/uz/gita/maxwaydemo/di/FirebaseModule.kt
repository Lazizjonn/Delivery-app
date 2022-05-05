package uz.gita.maxwaydemo.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
class FirebaseModule {

    @[Provides Singleton]
    fun getFirestoreDataBase() = FirebaseFirestore.getInstance()

    @[Provides Singleton]
    fun getFirebaseAuth(): FirebaseAuth = Firebase.auth

    @[Provides Singleton]
    fun getDeliveryReference(database: FirebaseDatabase): DatabaseReference = database.getReference("delivery")

}