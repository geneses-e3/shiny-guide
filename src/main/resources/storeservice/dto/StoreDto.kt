package com.geneses.storeservice.dto

data class StoreDto(
    val id: String?,
    val name: String,
    val handle: String,
    val description: String,
    val location: String,
    val ownerId: String,
)