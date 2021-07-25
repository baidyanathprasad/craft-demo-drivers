package com.baidyanath

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import io.dropwizard.db.DataSourceFactory
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration
import org.hibernate.validator.constraints.NotEmpty
import javax.validation.Valid

data class AppConfig(
    @JsonProperty("template")
    val template: String = "",

    @JsonProperty("defaultName")
    val defaultName: String = "",

    @JsonProperty("version")
    val version: String = "",

    @JsonProperty("database")
    @Valid
    val database: DataSourceFactory = DataSourceFactory(),

    @JsonProperty("swagger")
    @Valid
    val swaggerBundleConfiguration: SwaggerBundleConfiguration = SwaggerBundleConfiguration()

) : Configuration()