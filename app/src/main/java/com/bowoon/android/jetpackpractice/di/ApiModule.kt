package com.bowoon.android.jetpackpractice.di

import com.bowoon.android.jetpackpractice.api.providePokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Provides
    @Singleton
    fun provideRetrofit() = providePokemonApi()
}