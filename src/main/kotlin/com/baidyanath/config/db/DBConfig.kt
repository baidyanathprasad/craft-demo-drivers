package com.baidyanath.config.db

import com.baidyanath.AppConfig
import io.dropwizard.setup.Environment
import org.jdbi.v3.core.Jdbi

object DBConfig {

    private lateinit var appConfig: AppConfig
    private lateinit var environment: Environment
    private lateinit var jdbi: Jdbi

    fun initialize(
        appConfig: AppConfig,
        environment: Environment,
        jdbi: Jdbi
    ) {
        this.appConfig = appConfig
        this.environment = environment
        this.jdbi = jdbi
    }

    fun get() = jdbi
}