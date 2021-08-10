package com.bowoon.android.jetpackpractice.api

import com.bowoon.android.jetpackpractice.base.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

private val json = Json { ignoreUnknownKeys = true }

@ExperimentalSerializationApi
fun providePokemonApi(): Pokemon =
    Retrofit.Builder().apply {
        baseUrl(BASE_URL)
        client(createOkHttpClient())
        addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    }.build().create(Pokemon::class.java)

fun createOkHttpClient(): OkHttpClient =
    OkHttpClient.Builder().apply {
        addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
    }.build()