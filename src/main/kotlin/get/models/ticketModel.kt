package get.models

import kotlinx.serialization.Serializable
import javax.security.auth.Destroyable

@Serializable
data class CreateTicket(
    val requester: String,
    val toSupport: String,
    val category: Int,
    val subCategory: Int,
    val description: String,
    val reportedVia: Int,
    val floor: Int,
    val areaLoc: Int,
    val assignDepartment: Int,
    val assignTo: String,
): Destroyable


@Serializable
data class GetAllTickets(
    val ticketId: String,
    val ticketStatus: String,
    val ticketStatusCode: Int,
    val requester: String,
    val toSupport: String,
    val category: String,
    val subCategory: String,
    val assignedDepartment: String,
    val area: String,
    val floor: String,
    val reportedVia:String,
    val assignTo: String,
    val assignToId: String,
    val coAssign: String,
    val dateTime: String
): Destroyable
