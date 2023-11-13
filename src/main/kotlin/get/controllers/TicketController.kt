package get.controllers

import get.functions.timeDate
import get.models.GetAllTickets
import get.plugins.DBConfig
import get.queries.*

class TicketController {
    fun getAllTicket(): MutableList<GetAllTickets>{
    val con = DBConfig().connection()
        con.use { con ->
            val allTicketData = mutableListOf<GetAllTickets>()
            con.prepareStatement(getAllTickets).use {
                it.executeQuery().use { data ->
                    while (data.next()){
                        val ticketId = data.getString("ticket_id")
                        val statusName = data.getString("status_name")
                        val statusCode = data.getInt("status_code")
                        val requesterFirstName = data.getString("requester_fname")
                        val requesterLastName = data.getString("requester_lname")
                        val requesterName = "$requesterLastName, $requesterFirstName"
                        val toSupportFirstName = data.getString("tosupport_fname")
                        val toSupportLastName = data.getString("tosupport_lname")
                        val toSupportName = "$toSupportLastName, $toSupportFirstName"
                        val categoryName = data.getString("category_name")
                        val subCategoryName = data.getString("sub_category_name")
                        val areaName = data.getString("area_loc_name")
                        val floorName = data.getString("floor_name")
                        val reportedVia = data.getString("reported_via_name")
                        val assignDepartmentName = data.getString("assign_department_name")
                        val assignToFirstName = data.getString("assign_to_name")
                        val assignToLastName = data.getString("assign_to_lastname")
                        val assignToName = "$assignToLastName, $assignToFirstName"
                        val assignToID = data.getString("assign_to_id")
                        val coAssignFirstName = data.getString("co_assign_name")
                        val coAssignLastName = data.getString("co_assign_lastname")
                        val coAssign = "$coAssignLastName, $coAssignFirstName"
                        val dateTime = data.getString("time_data")
                        allTicketData.add(GetAllTickets(
                            ticketId,
                            statusName,
                            statusCode,
                            requesterName,
                            toSupportName,
                            categoryName,
                            subCategoryName,
                            assignDepartmentName,
                            areaName,
                            floorName,
                            reportedVia,
                            assignToName,
                            assignToID,
                            coAssign,
                            dateTime
                        ))
                    }
                    return allTicketData
                }
            }
        }
    }
    fun getOpenTicket(): MutableList<GetAllTickets>{
        val con = DBConfig().connection()
        con.use { con ->
            val allTicketData = mutableListOf<GetAllTickets>()
            con.prepareStatement(getOpenTickets).use {
                it.executeQuery().use { data ->
                    while (data.next()){
                        val ticketId = data.getString("ticket_id")
                        val statusName = data.getString("status_name")
                        val statusCode = data.getInt("status_code")
                        val requesterFirstName = data.getString("requester_fname")
                        val requesterLastName = data.getString("requester_lname")
                        val requesterName = "$requesterLastName, $requesterFirstName"
                        val toSupportFirstName = data.getString("tosupport_fname")
                        val toSupportLastName = data.getString("tosupport_lname")
                        val toSupportName = "$toSupportLastName, $toSupportFirstName"
                        val categoryName = data.getString("category_name")
                        val subCategoryName = data.getString("sub_category_name")
                        val areaName = data.getString("area_loc_name")
                        val floorName = data.getString("floor_name")
                        val reportedVia = data.getString("reported_via_name")
                        val assignDepartmentName = data.getString("assign_department_name")
                        val assignToFirstName = data.getString("assign_to_name")
                        val assignToLastName = data.getString("assign_to_lastname")
                        val assignToName = "$assignToLastName, $assignToFirstName"
                        val assignToID = data.getString("assign_to_id")
                        val coAssignFirstName = data.getString("co_assign_name")
                        val coAssignLastName = data.getString("co_assign_lastname")
                        val coAssign = "$coAssignLastName, $coAssignFirstName"
                        val dateTime = data.getString("time_data")
                        allTicketData.add(GetAllTickets(
                            ticketId,
                            statusName,
                            statusCode,
                            requesterName,
                            toSupportName,
                            categoryName,
                            subCategoryName,
                            assignDepartmentName,
                            areaName,
                            floorName,
                            reportedVia,
                            assignToName,
                            assignToID,
                            coAssign,
                            dateTime
                        ))
                    }
                    return allTicketData
                }
            }
        }
    }
    fun getOnGoingTicket(): MutableList<GetAllTickets>{
        val con = DBConfig().connection()
        con.use { con ->
            val allTicketData = mutableListOf<GetAllTickets>()
            con.prepareStatement(getOnGoingTickets).use {
                it.executeQuery().use { data ->
                    while (data.next()){
                        val ticketId = data.getString("ticket_id")
                        val statusName = data.getString("status_name")
                        val statusCode = data.getInt("status_code")
                        val requesterFirstName = data.getString("requester_fname")
                        val requesterLastName = data.getString("requester_lname")
                        val requesterName = "$requesterLastName, $requesterFirstName"
                        val toSupportFirstName = data.getString("tosupport_fname")
                        val toSupportLastName = data.getString("tosupport_lname")
                        val toSupportName = "$toSupportLastName, $toSupportFirstName"
                        val categoryName = data.getString("category_name")
                        val subCategoryName = data.getString("sub_category_name")
                        val areaName = data.getString("area_loc_name")
                        val floorName = data.getString("floor_name")
                        val reportedVia = data.getString("reported_via_name")
                        val assignDepartmentName = data.getString("assign_department_name")
                        val assignToFirstName = data.getString("assign_to_name")
                        val assignToLastName = data.getString("assign_to_lastname")
                        val assignToName = "$assignToLastName, $assignToFirstName"
                        val assignToID = data.getString("assign_to_id")
                        val coAssignFirstName = data.getString("co_assign_name")
                        val coAssignLastName = data.getString("co_assign_lastname")
                        val coAssign = "$coAssignLastName, $coAssignFirstName"
                        val dateTime = data.getString("time_data")
                        allTicketData.add(GetAllTickets(
                            ticketId,
                            statusName,
                            statusCode,
                            requesterName,
                            toSupportName,
                            categoryName,
                            subCategoryName,
                            assignDepartmentName,
                            areaName,
                            floorName,
                            reportedVia,
                            assignToName,
                            assignToID,
                            coAssign,
                            dateTime
                        ))
                    }
                    return allTicketData
                }
            }
        }
    }
    fun createTicketController(
        ticketId: String,
        requestersId: String,
        toSupport: String,
        category: Int,
        subCategory: Int,
        department: Int,
        floor: Int,
        area: Int,
        reportedVia: Int,
        assignTo: String,
        datetime: String
    ){
        TicketFunctions().findAllInputs(
            requestersId,
            toSupport,
            assignTo
        )
        var assignToId = "USR-000"
        var status = 1
        if (assignTo.isNotEmpty()){
            assignToId = assignTo
            status = 2
        }
        DBConfig().connection().use { con ->
            con.prepareStatement(createTicketQuery).use {
                it.setString(1, ticketId)
                it.setString(2, requestersId)
                it.setString(3, toSupport)
                it.setInt(4, category)
                it.setInt(5, subCategory)
                it.setInt(6, area)
                it.setInt(7, floor)
                it.setInt(8, reportedVia)
                it.setInt(9, department)
                it.setString(10, assignToId)
                it.setString(11, "USR-000")
                it.setString(12, datetime)
                it.setInt(13, status)

                it.executeUpdate()
            }
        }
    }

    /*
    * ticket Status updated controller starts here
    * */

    fun ticketAssigned(toAssignSupportId: String, ticketId: String){
        DBConfig().connection().use { con ->
            con.prepareStatement(ticketUpdateToAssigned).use {
                it.setString(1, toAssignSupportId)
                it.setString(2, timeDate())
                it.setString(3, ticketId)

                it.executeUpdate()
            }
        }
    }

    fun ticketResolved(ticketId: String){
        DBConfig().connection().use { con ->
            con.prepareStatement(ticketUpdateToResolved).use {
                it.setString(1, timeDate())
                it.setString(2, ticketId)

                it.executeUpdate()
            }
        }
    }
}



