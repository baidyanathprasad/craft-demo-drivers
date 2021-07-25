package com.baidyanath.drivers.data.dao

import com.baidyanath.drivers.data.querymappers.DriverBasicInfoQueryModelRowMapper
import com.baidyanath.drivers.data.querymodels.DriverBasicInfoQueryModel
import org.jdbi.v3.sqlobject.config.RegisterRowMapper
import org.jdbi.v3.sqlobject.customizer.BindBean
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate

interface DriversDao {

    @SqlUpdate(
        """
            insert into `Drivers_Basic Info` (
                `id`, `name`, `email`, `phone`, `ext`, `created_on`, `updated_on`, `licence_id`    
            )
            values (:id, :name, :email, :phone, :ext, default, default, :licenceId)
        """
    )
    fun addDriver(@BindBean driverBasicInfoQueryModel: DriverBasicInfoQueryModel)

    @RegisterRowMapper(DriverBasicInfoQueryModelRowMapper::class)
    @SqlQuery(
        """
            select `id`, `name`, `email`, `phone`, `ext`, `created_on`, `updated_on`, `licence_id`
            from `Drivers_Basic Info`
        """
    )
    fun getDrivers(): List<DriverBasicInfoQueryModel>
}