package com.baidyanath.config.resource

import com.baidyanath.drivers.DriverResource
import io.dropwizard.setup.Environment

class ResourceConfig(private val environment: Environment) {

    fun register() {
        environment.jersey().register(DriverResource::class.java)
    }
}