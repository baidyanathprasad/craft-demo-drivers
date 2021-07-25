package com.baidyanath.utils.api

import com.fasterxml.jackson.annotation.JsonProperty
import javax.ws.rs.core.Response

data class GenericResponse<T>(

    @JsonProperty("message")
    val message: MessageType,
    val data: T,
    val status: Response.Status
)