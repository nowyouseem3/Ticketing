package get.controllers

import get.models.*
import get.plugins.DBConfig
import get.queries.*

class GetTicketController  {
    // controller for getting to support and requestor
    fun getRequestor(): MutableList<GetRequestor>{
        val requestorData = mutableListOf<GetRequestor>()
        val requestorQuery = DBConfig().connection().prepareStatement(getRequestor)
        val getRequestorResult = requestorQuery.executeQuery()
        while (getRequestorResult.next()){
            val id = getRequestorResult.getInt("requestor_id")
            val name = getRequestorResult.getString("requestor_name")

            requestorData.add(GetRequestor(id,name))
        }

        return requestorData
    }

    fun getToSupport(): MutableList<GetToSupport>{
        val toSupportData = mutableListOf<GetToSupport>()
        val toSupportQuery = DBConfig().connection().prepareStatement(getToSupport)
        val toSupportResult = toSupportQuery.executeQuery()
        while (toSupportResult.next()){
            val id = toSupportResult.getInt("requestor_id")
            val name = toSupportResult.getString("requestor_name")

            toSupportData.add(GetToSupport(id,name))
        }

        return toSupportData
    }

    // start functions for getting sub, category, and assigned department
    private fun getMutableSubCategory(categoryId: Int): MutableList<GetSubCategory>{
        val subCategoryData = mutableListOf<GetSubCategory>()
        val subCategoryQuery = DBConfig().connection().prepareStatement(getMutableSubCategory)
        subCategoryQuery.setInt(1, categoryId)
        val subCategoryResult = subCategoryQuery.executeQuery()
        while (subCategoryResult.next()){
            val categoryID = subCategoryResult.getInt("category_id_relation")
            val id = subCategoryResult.getInt("sub_category_id")
            val name = subCategoryResult.getString("sub_category_name")

            subCategoryData.add(GetSubCategory(categoryID,id,name))
        }

        return subCategoryData
    }

    fun getCategory():MutableList<GetCategory>{
        val categoryData = mutableListOf<GetCategory>()
        val categoryQuery = DBConfig().connection().prepareStatement(getCategory)
        val categoryResult = categoryQuery.executeQuery()
        while (categoryResult.next()){
            val id = categoryResult.getInt("category_id")
            val name = categoryResult.getString("category_name")

            categoryData.add(GetCategory(id,name,getMutableSubCategory(id)))
        }

        return categoryData
    }

    fun getSubCategory():MutableList<GetSubCategory>{
        val subCategoryData = mutableListOf<GetSubCategory>()
        val subCategoryQuery = DBConfig().connection().prepareStatement(getSubCategory)
        val subCategoryResult = subCategoryQuery.executeQuery()
        while (subCategoryResult.next()){
            val id = subCategoryResult.getInt("sub_category_id")
            val name = subCategoryResult.getString("sub_category_name")
            val relationId = subCategoryResult.getInt("category_id_relation")

            subCategoryData.add(GetSubCategory(relationId,id,name))
        }

        return subCategoryData
    }

    fun getAssignedDepartment(): MutableList<GetAssignedDepartment>{
        val assignedDepartmentData = mutableListOf<GetAssignedDepartment>()
        val assignedDepartmentQuery = DBConfig().connection().prepareStatement(getAssignedDepartment)
        val assignedDepartmentResult = assignedDepartmentQuery.executeQuery()
        while (assignedDepartmentResult.next()){
            val id = assignedDepartmentResult.getInt("assigned_department_id")
            val relationId = assignedDepartmentResult.getInt("sub_category_id")
            val name = assignedDepartmentResult.getString("assign_department_name")

            assignedDepartmentData.add(GetAssignedDepartment(id,relationId,name))
        }

        return assignedDepartmentData
    }

    // start of functions for getting designation area
    fun getAreaLoc(): MutableList<GetAreaLocation>{
        val areaLocData = mutableListOf<GetAreaLocation>()
        val areaLocQuery = DBConfig().connection().prepareStatement(getAreaLoc)
        val areaLocResult = areaLocQuery.executeQuery()
        while (areaLocResult.next()){
            val id = areaLocResult.getInt("area_loc_id")
            val name = areaLocResult.getString("area_loc_name")
            val floorIdRelation = areaLocResult.getInt("floor_id_relation")

            areaLocData.add(GetAreaLocation(floorIdRelation,id,name))
        }

        return areaLocData
    }

    fun getDestination(): MutableList<GetFloor>{
        val destinationData = mutableListOf<GetFloor>()
        val destinationQuery = DBConfig().connection().prepareStatement(getDestination)
        val destinationResult = destinationQuery.executeQuery()
        while (destinationResult.next()){
            val id = destinationResult.getInt("floor_id")
            val name = destinationResult.getString("floor_name")

            destinationData.add(GetFloor(id,name))
        }

        return destinationData
    }

    // start function for getting descriptions
    fun getDescription(): MutableList<GetDescription>{
        val descriptionData = mutableListOf<GetDescription>()
        val descriptionQuery = DBConfig().connection().prepareStatement(getDescription)
        val descriptionResult = descriptionQuery.executeQuery()
        while (descriptionResult.next()){
            val id = descriptionResult.getInt("description_id")
            val name = descriptionResult.getString("description")

            descriptionData.add(GetDescription(id,name))
        }

        return descriptionData
    }

    //function for getting reported via
    fun getReportedVia(): MutableList<GetReportedVia>{
        val reportedViaData = mutableListOf<GetReportedVia>()
        val reportedViaQuery = DBConfig().connection().prepareStatement(reportedViaQuery)
        val reportedViaResult = reportedViaQuery.executeQuery()
        while (reportedViaResult.next()){
            val id = reportedViaResult.getInt("reported_via_id")
            val name = reportedViaResult.getString("reported_via_name")

            reportedViaData.add(GetReportedVia(id,name))
        }

        return reportedViaData
    }

    // start of function for getting assign and co assign
    fun getAssignTo(): MutableList<GetAssignTo>{
        val assignToData = mutableListOf<GetAssignTo>()
        val assignToQuery = DBConfig().connection().prepareStatement(assignToQuery)
        val assignToResult = assignToQuery.executeQuery()
        while (assignToResult.next()){
            val id = assignToResult.getInt("assign_to_id")
            val name = assignToResult.getString("assign_to_name")

            assignToData.add(GetAssignTo(id,name))
        }

        return assignToData
    }

    fun getCoAssignTo(assignToId: Int): MutableList<GetCoAssignTo>{
        val coAssignToData = mutableListOf<GetCoAssignTo>()
        val coAssignToQuery = DBConfig().connection().prepareStatement(coAssignToQuery)
        coAssignToQuery.setInt(1, assignToId)
        val coAssignToResult = coAssignToQuery.executeQuery()
        while (coAssignToResult.next()){
            val id = coAssignToResult.getInt("assign_to_id")
            val name = coAssignToResult.getString("assign_to_name")

            coAssignToData.add(GetCoAssignTo(id,name))
        }

        return coAssignToData
    }
    // end of getting data from database
}

class InsertTicketController{
    //start of inserting to database
    fun insertRequestorFun(requestorName: String){
        val insertRequestorQuery = DBConfig().connection().prepareStatement(insertRequestor)
        insertRequestorQuery.setString(1, requestorName)

        insertRequestorQuery.executeUpdate()
    }

    fun insertCategoryFun(categoryName: String){
        val insertCategoryQuery = DBConfig().connection().prepareStatement(insertCategory)
        insertCategoryQuery.setString(1, categoryName)

        insertCategoryQuery.executeUpdate()
    }

    fun insertSubCategoryFun(subCategoryName: String, categoryId: Int){
        val insertCategoryQuery = DBConfig().connection().prepareStatement(insertSubCategory)
        insertCategoryQuery.setString(1, subCategoryName)
        insertCategoryQuery.setInt(2, categoryId)

        insertCategoryQuery.executeUpdate()
    }

    fun insertFloorFun(floorName: String){
        val insertFloorQuery = DBConfig().connection().prepareStatement(insertDestination)
        insertFloorQuery.setString(1, floorName)

        insertFloorQuery.executeUpdate()
    }

    fun insertAreaFun(areaLocation: String, floorId: Int){
        val insertFloorQuery = DBConfig().connection().prepareStatement(insertAreaLocation)
        insertFloorQuery.setString(1, areaLocation)
        insertFloorQuery.setInt(2, floorId)

        insertFloorQuery.executeUpdate()
    }

    fun insertReportedViaFun(reportedViaDetails: String){
        val insertReportedViaQuery = DBConfig().connection().prepareStatement(insertReportedViaQuery)
        insertReportedViaQuery.setString(1, reportedViaDetails)

        insertReportedViaQuery.executeUpdate()
    }

    fun insertAssignDepartmentFun(assignDepartment: String, subCategoryId: Int){
        val insertReportedViaQuery = DBConfig().connection().prepareStatement(insertAssignedDepartment)
        insertReportedViaQuery.setInt(1, subCategoryId)
        insertReportedViaQuery.setString(2, assignDepartment)

        insertReportedViaQuery.executeUpdate()
    }

    fun insertAssignToFun(assignTo: String){
        val insertAssignToQuery = DBConfig().connection().prepareStatement(insertAssignToQuery)
        insertAssignToQuery.setString(1, assignTo)

        insertAssignToQuery.executeUpdate()
    }

}