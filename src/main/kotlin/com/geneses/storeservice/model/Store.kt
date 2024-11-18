package com.geneses.com.geneses.storeservice.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "stores")
data class Store (
    @Id
    val id: String? = null,
    val name: String,
    val handle: String,
    val description: String,
    val location: String,
    val ownerId: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)