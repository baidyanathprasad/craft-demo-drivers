package com.baidyanath.drivers.data.querymodels

import com.baidyanath.drivers.api.DriversResponse
import java.util.*

data class DriverBasicInfoQueryModel(
    val id: String,
    val name: String,
    val email: String,
    val phone: Int,
    val ext: String,
    val createdOn: Date,
    val updatedOn: Date,
    val licenceId: String
) {

    fun asResponse() = DriversResponse(
        id = id,
        name = name,
        email = email,
        phone = phone,
        ext = ext,
        createdOn = createdOn,
        updatedOn = updatedOn,
        licenceId = licenceId,
        onboardings = emptyList()
    )
}