package com.bowoon.android.jetpackpractice.api

import com.bowoon.android.jetpackpractice.model.PokemonResponse
import kotlinx.coroutines.Deferred
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.net.SocketTimeoutException

interface Pokemon {
    /**
     * 200
     */
    @GET("pokemon")
    suspend fun getPokemon(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): PokemonResponse
}