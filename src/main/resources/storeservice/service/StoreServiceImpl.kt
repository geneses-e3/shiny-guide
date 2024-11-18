package com.geneses.storeservice.service

import com.geneses.storeservice.exception.StoreNotFoundException
import com.geneses.storeservice.model.Store
import com.geneses.storeservice.repository.StoreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StoreServiceImpl @Autowired constructor(private val storeRepository: StoreRepository) : StoreService {



    override fun createStore(store: Store): Store {
        return storeRepository.save(store)
    }

    override fun getAllStores(): List<Store> {
        return storeRepository.findAll()
    }

    override fun getStoresByOwner(ownerId: String): List<Store> {
        return storeRepository.findByOwnerId(ownerId)
    }

    override fun getStoreById(id: String): Store? {
        return storeRepository.findById(id).orElseThrow {
            StoreNotFoundException("Store with ID $id not found")
        }
    }

    override fun updateStore(id: String, store: Store): Store? {
        val existingStore = storeRepository.findById(id).orElse(null)
        return if (existingStore != null) {
            val updatedStore = existingStore.copy(
                name = store.name,
                description = store.description,
                location = store.location,
                updatedAt = System.currentTimeMillis()
            )
            storeRepository.save(updatedStore)
        } else {
            null
        }
    }

    override fun deleteStore(id: String) {
        return storeRepository.deleteById(id)
    }
}