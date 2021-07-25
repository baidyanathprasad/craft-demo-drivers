package com.baidyanath.drivers.data.store

import com.baidyanath.drivers.api.DriversResponse
import com.baidyanath.drivers.domain.DriverInput

interface DriverStore {

    fun createDriver(driverInput: DriverInput): DriversResponse

    fun fetchAllDrivers(): List<DriversResponse>
}