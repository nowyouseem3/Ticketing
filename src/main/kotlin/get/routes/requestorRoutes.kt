package get.routes


import get.controllers.GetTicketController
import get.models.GenericResponse
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.requestorRouting(){
    route("/requestor") {
        get {
            try {
                val requestor = GetTicketController().getRequestor()
                call.respond(GenericResponse("Success", 200, data = requestor))
            }catch (e: Exception){
                call.respond(GenericResponse("Server Error", 500, data = e))
            }
        }
    }
}