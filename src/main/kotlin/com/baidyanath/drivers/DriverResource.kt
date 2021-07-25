package com.baidyanath.drivers

import com.baidyanath.drivers.data.store.DriverStoreImpl
import com.baidyanath.drivers.domain.DriverInput
import com.baidyanath.utils.api.GenericResponse
import com.baidyanath.utils.api.MessageType
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/api/v1/drivers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class DriverResource() {

    private val driverStore = DriverStoreImpl()

    @Path("/signup")
    @POST
    fun addDriver(
        @Valid driver: DriverInput
    ): Response {
        return try {
            val driverResponse = driverStore.createDriver(driver)
            Response
                .ok(
                    GenericResponse(
                        message = MessageType.SUCCESS,
                        data = driverResponse,
                        status = Response.Status.CREATED
                    )
                )
                .build()

        } catch (e: Exception) {
            Response.ok(
                GenericResponse(
                    message = MessageType.FAILED,
                    data = e.localizedMessage,
                    status = Response.Status.INTERNAL_SERVER_ERROR
                )
            ).build()
        }
    }

    @GET
    fun fetchAllDrivers(): Response {

        try {
            val drivers = driverStore.fetchAllDrivers()
            return Response
                .ok(
                    GenericResponse(
                        message = MessageType.SUCCESS,
                        data = drivers,
                        status = Response.Status.OK
                    )
                )
                .build()
        } catch (e: Exception) {
            return Response
                .ok(
                    GenericResponse(
                        message = MessageType.SUCCESS,
                        data = e.localizedMessage,
                        status = Response.Status.INTERNAL_SERVER_ERROR
                    )
                )
                .build()
        }

    }
}