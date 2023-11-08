package get.routes.TicketRoutes

import get.controllers.TicketController
import get.models.GenericResponse
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.displayTicketRouting(){
    route("/all-tickets") {
        get {
            try {
                val ticket = TicketController().getAllTicket()
                try {
                    call.respond(GenericResponse("Success", 200, data = ticket))
                }finally {
                    ticket.clear()
                }

            }catch (e: Exception){
                call.respond(GenericResponse("Server Error", 500, data = "Message: $e"))
            }
        }
    }
}
