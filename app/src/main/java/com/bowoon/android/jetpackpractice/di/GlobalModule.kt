package com.bowoon.android.jetpackpractice.di

import android.content.Context
import com.bowoon.android.jetpackpractice.room.RoomHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GlobalModule {
    @Provides
    @Singleton
    fun provideRoomDataBase(
        @ApplicationContext context: Context
    ): RoomHelper = RoomHelper.getInstance(context)
}