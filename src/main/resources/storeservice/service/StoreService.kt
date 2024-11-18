package com.geneses.storeservice.service

import com.geneses.storeservice.model.Store



interface StoreService {
    fun createStore(store: Store): Store
    fun getAllStores(): List<Store>
    fun getStoresByOwner(ownerId: String): List<Store>
    fun getStoreById(id: String): Store?
    fun updateStore(id: String, store: Store): Store?
    fun deleteStore(id: String)
}
