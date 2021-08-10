package com.bowoon.android.jetpackpractice.room

import androidx.paging.PagingSource
import androidx.room.*
import com.bowoon.android.jetpackpractice.model.Pokemon

@Dao
interface PokemonDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pokemon: WishPokemon)

    @Delete
    fun delete(pokemon: WishPokemon)

    @Query("SELECT * FROM pokemon")
    fun getPokemonList(): PagingSource<Int, Pokemon>

    @Query("DELETE FROM pokemon")
    fun deleteAll()

    @Query("DELETE FROM wish_pokemon")
    fun wishDeleteAll()

    @Query("SELECT * FROM wish_pokemon WHERE wish_pokemon.name = :name")
    fun findPokemon(name: String): WishPokemon?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(results: List<RoomPokemon>)

    @Query("SELECT * FROM wish_pokemon")
    fun getWishPokemon(): PagingSource<Int, WishPokemon>

    @Query("SELECT * FROM wish_pokemon")
    fun getWishPokemonList(): List<WishPokemon>?
}