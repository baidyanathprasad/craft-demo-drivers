package com.baidyanath.drivers.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class DriverInput(
    
    @JsonProperty("name")
    val name: String,
    
    @JsonProperty("email")
    val email: String,
    
    @JsonProperty("phone")
    val phone: Int,
    
    @JsonProperty("ext")
    val ext: String,
    
    @JsonProperty("licenceId")
    val licenceId: String
)