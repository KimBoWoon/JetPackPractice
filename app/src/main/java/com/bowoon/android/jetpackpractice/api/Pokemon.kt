package com.bowoon.android.jetpackpractice.api

import com.bowoon.android.jetpackpractice.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Pokemon {
    /**
     * 200
     */
    @GET("pokemon")
    suspend fun getPokemon(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): PokemonResponse

    /**
     * 404
     */
//    @GET("asdf")
//    suspend fun getPokemon(
//        @Query("limit") limit: Int = 20,
//        @Query("offset") offset: Int = 0
//    ): PokemonResponse
}