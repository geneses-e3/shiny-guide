package com.geneses.com.geneses.storeservice.controller

import com.geneses.com.geneses.storeservice.model.Store
import com.geneses.com.geneses.storeservice.service.StoreService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/stores")
class StoreController @Autowired constructor ( private val storeService: StoreService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createStore(@RequestBody store: Store) : Store {
        return storeService.createStore(store)
    }

    @GetMapping
    fun getAllStores() : List<Store> {
        return storeService.getAllStores()
    }

    @GetMapping("/owner/{ownerId}")
    fun getStoresByOwner(@PathVariable ownerId: String) : List<Store> {
        return storeService.getStoresByOwner(ownerId)
    }

    @GetMapping("/{id}")
    fun getStoreById(@PathVariable id: String) : Store? {
        return storeService.getStoreById(id)
    }

    @PutMapping("/{id}")
    fun updateStore(@PathVariable id: String, @RequestBody store: Store) : Store? {
        return storeService.updateStore(id, store)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteStore(@PathVariable id: String) {
        return storeService.deleteStore(id)
    }

}