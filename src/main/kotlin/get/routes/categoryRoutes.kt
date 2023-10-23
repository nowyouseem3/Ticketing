package get.routes

import get.controllers.GetTicketController
import get.models.GenericResponse
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.categoryRouting(){
    route("/category") {
        get {
            try {
                val category = GetTicketController().getAssignTo()
                call.respond(GenericResponse("Success", 200, data = category))
            }catch (e: Exception){
                call.respond(GenericResponse("Server Error", 500, data = e))
            }
        }
    }
}