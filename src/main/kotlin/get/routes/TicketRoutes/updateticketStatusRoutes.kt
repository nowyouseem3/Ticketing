package get.routes.TicketRoutes

import get.controllers.TicketController
import get.models.GenericResponse
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.updateTicketRouting(){
    route("/assignUpdate") {
        get("{supportUserId?}/{ticketId?}") {
            try {
                val supportId = call.parameters["supportUserId"].toString()
                val ticketId = call.parameters["ticketId"].toString()
                TicketController().ticketAssigned(supportId,ticketId)
                call.respond(GenericResponse("Success", 200, data = "Status Updated"))
            }catch (e: Exception){
                call.respond(GenericResponse("Server Error", 500, data = "Message: $e"))
            }
        }
    }

    route("/resolveUpdate") {
        get("{ticketId?}") {
            try {
                val ticketId = call.parameters["ticketId"].toString()
                TicketController().ticketResolved(ticketId)
                call.respond(GenericResponse("Success", 200, data = "Status Updated"))
            }catch (e: Exception){
                call.respond(GenericResponse("Server Error", 500, data = "Message: $e"))
            }
        }
    }
}
