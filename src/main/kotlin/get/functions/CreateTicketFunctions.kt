package get.functions

import get.controllers.*
import kotlin.math.floor

// start function for validation to get the requestor or insert if not exist
    private fun requestorValidationTest(requestorName: String){
        val requestorStorage = GetTicketController().getRequestor()
        requestorStorage.find { it.requestorName == requestorName }?: InsertTicketController().insertRequestorFun(requestorName)
    }

    fun requestorValidationFinal(requestorName: String):Int{
        requestorValidationTest(requestorName)
        val requestorStorage = GetTicketController().getRequestor()
        val requestorResult = requestorStorage.find { it.requestorName == requestorName }

        return requestorResult!!.requestorId
    }

    private fun toSupportValidationTest(requestorName: String){
        val requestorStorage = GetTicketController().getToSupport()
        requestorStorage.find { it.toSupportName == requestorName }?: InsertTicketController().insertRequestorFun(requestorName)
    }

    fun toSupportValidationFinal(requestorName: String):Int{
        toSupportValidationTest(requestorName)
        val toSupportStorage = GetTicketController().getToSupport()
        val toSupportResult = toSupportStorage.find { it.toSupportName == requestorName }

        return toSupportResult!!.toSupportID
    }

    // start function for validation to get category and sub category or insert if not exist
    private fun categoryValidationTest(categoryName: String){
        val categoryStorage = GetTicketController().getCategory()
        categoryStorage.find { it.categoryName == categoryName }?: InsertTicketController().insertCategoryFun(categoryName)
    }

    fun categoryValidationFinal(categoryName: String):Int{
        categoryValidationTest(categoryName)
        val categoryStorage = GetTicketController().getCategory()
        val categoryResult= categoryStorage.find { it.categoryName == categoryName }

        return categoryResult!!.categoryId
    }

    private fun subCategoryValidationTest(subCategoryName: String, categoryId: Int){
        val subCategoryStorage = GetTicketController().getSubCategory()
        subCategoryStorage.find { it.subCategoryName == subCategoryName }?: InsertTicketController().insertSubCategoryFun(subCategoryName, categoryId)

    }

    fun subCategoryValidationFinal(subCategoryName: String, categoryId: Int):Int{
        subCategoryValidationTest(subCategoryName, categoryId)
        val subCategoryStorage = GetTicketController().getSubCategory()
        val subCategoryResult= subCategoryStorage.find { it.subCategoryName == subCategoryName }

        return subCategoryResult!!.subCategoryId
    }

    // start function for validation to get floor and area or insert if not exist
    private fun floorValidationTest(floorName: String){
        val floorStorage = GetTicketController().getDestination()
        floorStorage.find { it.floorName == floorName }?: InsertTicketController().insertFloorFun(floorName)

    }

    fun floorValidationFinal(floorName: String):Int{
        floorValidationTest(floorName)
        val floorStorage = GetTicketController().getDestination()
        val floorResult = floorStorage.find { it.floorName == floorName}

        return floorResult!!.floorId
    }

    private fun areaValidationTest(areaLocation: String, floorId: Int){
        val areaStorage = GetTicketController().getAreaLoc()
        areaStorage.find { it.areaLocationName == areaLocation }?: InsertTicketController().insertAreaFun(areaLocation, floorId)

    }

    fun areaValidationFinal(areaLocation: String, floorId: Int):Int{
        areaValidationTest(areaLocation, floorId)
        val areaStorage = GetTicketController().getAreaLoc()
        val areaResult = areaStorage.find { it.areaLocationName == areaLocation}

        return areaResult!!.areaLocationId
    }

    //start function for validation of reported via or insert if not exist
    private fun reportedViaValidationTest(reportedViaName: String){
        val reportedViaStorage = GetTicketController().getReportedVia()
        reportedViaStorage.find { it.reportedViaDetails == reportedViaName }?: InsertTicketController().insertReportedViaFun(reportedViaName)

    }

    fun reportedViaValidationFinal(reportedViaName: String):Int{
        reportedViaValidationTest(reportedViaName)
        val reportedViaStorage = GetTicketController().getReportedVia()
        val reportedViaResult = reportedViaStorage.find { it.reportedViaDetails == reportedViaName}

        return reportedViaResult!!.reportedViaId
    }

    //start function for validation of assigned department or insert if not exist
    private fun assignedDepartmentValidationTest(assignedDepartmentName: String, subCategoryId: Int){
        val assignDepartmentStorage = GetTicketController().getAssignedDepartment()
        assignDepartmentStorage.find { it.assignedDepartmentName == assignedDepartmentName }?: InsertTicketController(). insertAssignDepartmentFun(assignedDepartmentName, subCategoryId)

    }

    fun assignDepartmentValidationFinal(assignedDepartmentName: String, subCategoryId: Int):Int{
        assignedDepartmentValidationTest(assignedDepartmentName, subCategoryId)
        val assignDepartmentStorage = GetTicketController().getAssignedDepartment()
        val assignedDepartmentResult = assignDepartmentStorage.find { it.assignedDepartmentName == assignedDepartmentName}

        return assignedDepartmentResult!!.assignedDepartmentId
    }

    //start function for validation for assigning to and co assign worker
    private fun assignToValidationTest(assignedToName: String){
        val assignToStorage = GetTicketController().getAssignTo()
        assignToStorage.find { it.assignToName == assignedToName }?: InsertTicketController(). insertAssignToFun(assignedToName)

    }

    fun assignToValidationFinal(assignedToName: String):Int{
        assignToValidationTest(assignedToName)
        val assignToStorage = GetTicketController().getAssignTo()
        val assignToResult = assignToStorage.find { it.assignToName == assignedToName}

        return assignToResult!!.assignToId
    }


    fun coAssignToValidationFinal(assignedToId: Int, coAssignedToName: String):Int{
        assignToValidationFinal(coAssignedToName)
        val coAssignToStorage = GetTicketController().getCoAssignTo(assignedToId)
        val coAssignToResult = coAssignToStorage.find { it.coAssignName == coAssignedToName}

        return coAssignToResult!!.coAssignId
    }