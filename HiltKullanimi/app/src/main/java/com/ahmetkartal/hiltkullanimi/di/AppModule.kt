package com.ahmetkartal.hiltkullanimi.di

import com.ahmetkartal.hiltkullanimi.Adres
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideAddres():Adres{
        return Adres("Kadıköy/Istanbul")

    }
}