package com.geneses.com.geneses.storeservice.repository

import com.geneses.com.geneses.storeservice.model.Store
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface StoreRepository : MongoRepository<Store, String> {
    fun findByOwnerId(ownerId: String): List<Store>
    fun findByHandle(handle: String): List<Store>
    fun findByName(name: String): List<Store>
}