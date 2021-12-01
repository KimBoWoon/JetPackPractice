package com.bowoon.android.jetpackpractice.model

//@Serializable
data class PokemonResponse(
    val count: Int? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: MutableList<PokemonModel.Pokemon>? = null
)