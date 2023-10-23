package get.routes

import get.functions.*
import get.models.GenericResponse
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import get.models.*
import io.ktor.server.request.*

fun Route.requestTicketRouting(){
    route("/request-ticket") {
        requestorRouting()
        categoryRouting()
        get {
            try {
                call.respond(GenericResponse("Success", 200, data = "request -ticket"))
            }catch (e: Exception){
                call.respond(GenericResponse("Server Error", 500, data = e))
            }
        }
        post {
            try {
                val ticketForm: CreateTicketTry = call.receive()
                //val categoryid = categoryValidationFinal(ticketForm.category)
                //val subCategoryId = subCategoryValidationFinal(ticketForm.subCategory, categoryid)
                call.respond(requestorValidationFinal(ticketForm.requestor))
            }catch (e: Exception){
                call.respond(e)
            }

        }
    }
}