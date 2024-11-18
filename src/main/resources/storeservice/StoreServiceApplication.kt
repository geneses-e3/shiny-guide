package com.geneses.storeservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class StoreServiceApplication

fun main(args: Array<String>) {
    runApplication<StoreServiceApplication>(*args)
}
