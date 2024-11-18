package com.geneses.storeservice.controller

import com.geneses.storeservice.dto.StoreDto
import com.geneses.storeservice.exception.StoreNotFoundException
import com.geneses.storeservice.model.Store
import com.geneses.storeservice.service.StoreService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/stores")
class StoreController @Autowired constructor(private val storeService: StoreService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createStore(@RequestBody store: Store): Store {
        return storeService.createStore(store)
    }

    @GetMapping
    fun getAllStores(): List<Store> {
        return storeService.getAllStores()
    }

    @GetMapping("/owner/{ownerId}")
    fun getStoresByOwner(@PathVariable ownerId: String): List<Store> {
        return storeService.getStoresByOwner(ownerId)
    }

    @GetMapping("/{id}")
    fun getStoreById(@PathVariable id: String): StoreDto {
        val store = storeService.getStoreById(id)
        return store?.let { StoreDto(it.id, it.name, it.description, it.handle, it.location, it.ownerId) }
            ?: throw StoreNotFoundException("Store with ID $id not found")
    }

    @PutMapping("/{id}")
    fun updateStore(@PathVariable id: String, @RequestBody store: Store): Store? {
        return storeService.updateStore(id, store)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteStore(@PathVariable id: String) {
        return storeService.deleteStore(id)
    }

}