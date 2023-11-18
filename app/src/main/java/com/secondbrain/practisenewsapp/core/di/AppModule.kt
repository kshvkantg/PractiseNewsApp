package com.secondbrain.practisenewsapp.core.di

import android.app.Application
import com.secondbrain.practisenewsapp.core.LocalUserManager
import com.secondbrain.practisenewsapp.core.LocalUserManagerImplementation
import com.secondbrain.practisenewsapp.onBarding.presentation.usecase.AppEntryUseCases
import com.secondbrain.practisenewsapp.onBarding.presentation.usecase.ReadAppEntry
import com.secondbrain.practisenewsapp.onBarding.presentation.usecase.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideLocalUserManager(
        application: Application
    ) : LocalUserManager = LocalUserManagerImplementation(application)

    @Provides
    fun providesAppEntryUseCase(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        saveEntry = SaveAppEntry(localUserManager),
        readAppEntry = ReadAppEntry(localUserManager)
    )
}