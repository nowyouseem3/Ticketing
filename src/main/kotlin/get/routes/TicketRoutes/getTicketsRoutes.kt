package get.routes.TicketRoutes

import get.controllers.TicketController
import get.models.GenericResponse
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.displayTicketRouting(){
    route("/all-tickets") {
        openTicketRouting()
        onGoingTicketRouting()
        updateTicketRouting()
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

fun Route.openTicketRouting(){
    route("/open") {
        get {
            try {
                val ticket = TicketController().getOpenTicket()
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

fun Route.onGoingTicketRouting(){
    route("/on-going") {
        get {
            try {
                val ticket = TicketController().getOnGoingTicket()
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
