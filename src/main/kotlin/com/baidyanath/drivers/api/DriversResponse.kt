package com.baidyanath.drivers.api

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*


data class DriversResponse(
    @JsonProperty("id")
    val id: String,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("email")
    val email: String,

    @JsonProperty("phone")
    val phone: Int,

    @JsonProperty("ext")
    val ext: String,

    @JsonProperty("createdOn")
    val createdOn: Date,

    @JsonProperty("lastUpdated")
    val updatedOn: Date,

    @JsonProperty("licenceId")
    val licenceId: String,
    
    @JsonProperty("onoardings")
    val onboardings: List<Any>
)