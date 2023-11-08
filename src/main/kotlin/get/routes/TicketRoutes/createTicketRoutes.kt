package get.routes.TicketRoutes

import get.controllers.TicketController
import get.controllers.TicketFunctions
import get.functions.ticketIdGen
import get.functions.timeDate
import get.models.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.requestTicketRouting(){
    route("/request-ticket") {
        post {
            try {
                val ticketDetails = call.receive<CreateTicket>()
                val (
                    requester,
                    toSupport,
                    category,
                    subCategory,
                    description,
                    reportedVia,
                    floor,
                    areaLoc,
                    assignDepartment,
                    assignTo
                ) = ticketDetails
                val ticketId = ticketIdGen()
                val ticketDate = timeDate()
                TicketController()
                    .createTicketController(
                        ticketId,
                        requester,
                        toSupport,
                        category,
                        subCategory,
                        assignDepartment,
                        floor,
                        areaLoc,
                        reportedVia,
                        assignTo,
                        ticketDate
                    )
                TicketFunctions()
                    .insertDescription(
                        description,
                        ticketId
                    )
                try {
                    call.respond(GenericResponse("Success", 200, data = "Ticket Created"))
                }finally {
                    ticketDetails.destroy()
                }
            }catch (e: Exception){
                call.respond(GenericResponse("Server Error", 500, data = "Message: $e"))
            }
        }
    }
    route("/ticket-requester") {
        get("{name?}") {
            try {
                val userName = call.parameters["name"]
                val name = TicketFunctions().getLiveUser("${userName?.capitalize()}%")
                if (userName.isNullOrBlank() ) call.respond(GenericResponse("Success", 200, data = TicketFunctions().getUser()))
                if (name.isEmpty()) call.respond(GenericResponse("Success", 200, data = "No Employee Found"))
                try {
                    call.respond(GenericResponse("Success", 200, data = name))
                }finally {
                    name.clear()
                }
            }catch (e: Exception){
                call.respond(GenericResponse("Server Error", 500, data = "Message: $e"))
            }
        }
    }

    route("/ticket-category") {
        get("{categoryName?}") {
            try {
                val categoryName = call.parameters["categoryName"]?.capitalize()
                var category = TicketFunctions().getLiveNestedCategory("${categoryName}%")
                if (categoryName.isNullOrBlank()) category = TicketFunctions().getNestedCategory()
                try {
                    call.respond(GenericResponse("Success", 200, data = category))
                }finally {
                    category.clear()
                }
            }
            catch (e: Exception){
                call.respond(GenericResponse("Server Error", 500, data = "Message: $e"))
            }
        }
    }

    route("/ticket-department") {
        get("{departmentName?}") {
            try {
                val categoryName = call.parameters["departmentName"]?.capitalize()
                var category = TicketFunctions().getLiveDepartment("${categoryName}%")
                if (categoryName.isNullOrBlank()) category = TicketFunctions().getDepartment()
                try {
                    call.respond(GenericResponse("Success", 200, data = category))
                }finally {
                    category.clear()
                }
            }
            catch (e: Exception){
                call.respond(GenericResponse("Server Error", 500, data = "Message: $e"))
            }
        }
    }

    route("/ticket-designation") {
        get("{designation?}") {
            try {
                val designationName = call.parameters["designation"]
                var designation = TicketFunctions().getLiveArea("${designationName}%")
                if (designationName.isNullOrBlank()) designation = TicketFunctions().getAllArea()
                try {
                    call.respond(GenericResponse("Success", 200, data = designation))
                }finally {
                    designation.clear()
                }
            }catch (e: Exception){
                call.respond(GenericResponse("Server Error", 500, data = "Message: $e"))
            }
        }
    }

    route("/ticket-reportedVia") {
        get("{reportedVia?}") {
            try {
                val reportedViaName = call.parameters["reportedVia"]
                var reportedVia = TicketFunctions().getLiveReportVia("${reportedViaName}%")
                if (reportedViaName.isNullOrBlank()) reportedVia = TicketFunctions().getReportVia()
                try {
                    call.respond(GenericResponse("Success", 200, data = reportedVia))
                }finally {
                    reportedVia.clear()
                }
            }catch (e: Exception){
                call.respond(GenericResponse("Server Error", 500, data = "Message: $e"))
            }
        }
    }

    route("/ticket-assignTo") {
        get("{departmentId?}/{assignTo?}") {
            try {
                val departmentId = call.parameters["departmentId"]
                val assignToName = call.parameters["assignTo"]?.capitalize()
                if (departmentId.isNullOrEmpty()) call.respond(GenericResponse("Success", 200, data = "No Department Set"))
                var assignTo = TicketFunctions().getLiveAssign(departmentId!!.toInt(),"${assignToName}%")
                if (assignToName.isNullOrBlank()) assignTo = TicketFunctions().getAllLiveAssign(departmentId.toInt())
                try {
                    call.respond(GenericResponse("Success", 200, data = assignTo))
                }finally {
                    assignTo.clear()
                }
            }catch (e: Exception){
                call.respond(GenericResponse("Server Error", 500, data = "Message: $e"))
            }
        }
    }

    route("/ticket-insert-subcategory"){
        post() {
            try {
                val subcategoryData = call.receive<SubCategoryResponse>()
                val (categoryId, subCategoryName, departmentId) = subcategoryData
                if (categoryId.toString().isNullOrBlank()) call.respond(GenericResponse("Success", 200, data = "Please Select Category"))
                    TicketFunctions().findInsertSubCategory(subCategoryName, categoryId, departmentId)
                call.respond(GenericResponse("Success", 200, data = "Created"))
            }catch (e: Exception){
                call.respond(GenericResponse("Server Error", 500, data = "Message: $e"))
            }
        }
    }
}
