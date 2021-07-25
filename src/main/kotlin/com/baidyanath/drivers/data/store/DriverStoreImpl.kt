package com.baidyanath.drivers.data.store

import com.baidyanath.config.db.DBConfig
import com.baidyanath.drivers.api.DriversResponse
import com.baidyanath.drivers.data.dao.DriversDao
import com.baidyanath.drivers.data.querymodels.DriverBasicInfoQueryModel
import com.baidyanath.drivers.domain.DriverInput
import com.baidyanath.utils.getUUID
import org.jdbi.v3.core.Handle
import org.jdbi.v3.core.transaction.TransactionIsolationLevel
import java.util.*

class DriverStoreImpl(
    private inline val provideDriversDao: (Handle) -> DriversDao = {
        it.attach(DriversDao::class.java)
    }
) : DriverStore {

    private val jdbi = DBConfig.get()
    private val driversDao = jdbi.onDemand(DriversDao::class.java)

    override fun createDriver(driverInput: DriverInput): DriversResponse {

        val driverModel = DriverBasicInfoQueryModel(
            id = getUUID(),
            name = driverInput.name,
            email = driverInput.email,
            phone = driverInput.phone,
            ext = driverInput.ext,
            createdOn = Date(),
            updatedOn = Date(),
            licenceId = driverInput.licenceId
        )

        try {
            jdbi.useTransaction<Exception?>(TransactionIsolationLevel.READ_COMMITTED) {
                val driversDao = provideDriversDao(it)
                driversDao.addDriver(driverModel)
            }
        } catch (e: Exception) {
            println(e.localizedMessage)
            throw RuntimeException("There was some issue while creating a record in system")
        }

        return driverModel.asResponse()
    }

    override fun fetchAllDrivers(): List<DriversResponse> {
        
        try {
            val drivers = driversDao.getDrivers()
            return drivers.map { it.asResponse() }
        } catch (e: Exception) {
            println(e.localizedMessage)
            throw RuntimeException("There was some issue while fetching drivers from system")
        }
    }
}