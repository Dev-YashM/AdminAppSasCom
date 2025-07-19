package com.example.sascomadmin.di

import com.example.sascomadmin.data.repository.AdminRepository
import com.example.sascomadmin.data.repository.FirebaseDataSource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // 🔥 Firestore instance
    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    // 🔥 Firebase Realtime Database instance
    @Provides
    @Singleton
    fun provideRealtimeDatabase(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

    // 🔐 FirebaseAuth instance (optional: for admin access control or fetching user emails)
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    // 📦 FirebaseDataSource - handles Firebase operations
    @Provides
    @Singleton
    fun provideFirebaseDataSource(
        firestore: FirebaseFirestore,
        realtimeDatabase: FirebaseDatabase
    ): FirebaseDataSource {
        return FirebaseDataSource(firestore, realtimeDatabase)
    }

    // 🧠 Repository layer abstraction
    @Provides
    @Singleton
    fun provideAdminRepository(
        firebaseDataSource: FirebaseDataSource
    ): AdminRepository {
        return AdminRepository(firebaseDataSource)
    }
}
