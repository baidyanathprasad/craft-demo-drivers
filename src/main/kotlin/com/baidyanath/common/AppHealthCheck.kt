package com.baidyanath.common

import com.codahale.metrics.health.HealthCheck

class AppHealthCheck(private val name: String) : HealthCheck() {

    override fun check() =
        (if (!name.contains("")) Result.unhealthy("Name doesn't include any character")
        else Result.healthy())!!
}