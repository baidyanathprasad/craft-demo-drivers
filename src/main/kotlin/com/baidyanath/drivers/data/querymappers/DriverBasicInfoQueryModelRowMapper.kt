package com.baidyanath.drivers.data.querymappers

import com.baidyanath.drivers.data.querymodels.DriverBasicInfoQueryModel
import org.jdbi.v3.core.mapper.RowMapper
import org.jdbi.v3.core.statement.StatementContext
import java.sql.ResultSet

class DriverBasicInfoQueryModelRowMapper : RowMapper<DriverBasicInfoQueryModel> {

    override fun map(rs: ResultSet, ctx: StatementContext) = rs.run {

        DriverBasicInfoQueryModel(
            id = getString("id"),
            name = getString("name"),
            email = getString("email"),
            phone = getInt("phone"),
            ext = getString("ext"),
            createdOn = getDate("created_on"),
            updatedOn = getDate("updated_on"),
            licenceId = getString("licence_id")
        )
    }
}