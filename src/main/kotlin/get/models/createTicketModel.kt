package get.models

import kotlinx.serialization.Serializable
import javax.security.auth.Destroyable

@Serializable
data class CreateTicket(
    val requestor: String,
    val toSupport: String,
    val category: String,
    val subCategory: String,
    val description: String,
    val reportedVia: String,
    val floor: String,
    val areaLoc: String,
    val assignDepartment: String,
    val assignTo: String,
    val coAssignTo: String
): Destroyable

@Serializable
data class CreateTicketTry(
    val requestor: String,
    val toSupport: String,
    val category: String,
    val subCategory: String,
    val area: String,
    val specifyArea: String,
    val reportVia: String,
    val assignDepartment: String,
    val assignTo: String,
    val coAssignTo: String
): Destroyable