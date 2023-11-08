package get.controllers

import get.plugins.DBConfig
import get.models.*
import get.queries.*

class TicketFunctions {

    /*
    * this function getting all dataset from db
    * */
    fun getUser(): MutableList<UserInfo>{
        DBConfig().connection().use { con ->
            con.prepareStatement(getUser).use {
                it.executeQuery().use { dataset ->
                    val dataResult = mutableListOf<UserInfo>()
                    while (dataset.next()){
                        val id = dataset.getString("user_id")
                        val fName = dataset.getString("first_name")
                        val lName = dataset.getString("last_name")
                        val name = "$lName, $fName"

                        dataResult.add(UserInfo(id, name))
                    }
                    return dataResult
                }
            }
        }
    }

    fun getLiveUser(name :String): MutableList<UserInfoLive>{
        DBConfig().connection().use { con ->
            con.prepareStatement(getLiveUser).use {
                it.setString(1, name)
                it.setString(2, name)
                it.executeQuery().use { dataset ->
                    val dataResult = mutableListOf<UserInfoLive>()
                    while (dataset.next()){
                        val id = dataset.getString("user_id")
                        val fName = dataset.getString("first_name")
                        val lName = dataset.getString("last_name")
                        val name = "$lName, $fName"

                        dataResult.add(UserInfoLive(id, name))
                    }
                    return dataResult
                }
            }
        }
    }
    private fun getRequester(): MutableList<Requester>{
        DBConfig().connection().use { con ->
            con.prepareStatement(getRequester).use {
                it.executeQuery().use { dataset ->
                    val dataResult = mutableListOf<Requester>()
                    while (dataset.next()){
                        val id = dataset.getString("user_id")
                        val fName = dataset.getString("requester_fname")
                        val lName = dataset.getString("requester_lname")
                        val name = "$lName, $fName"

                        dataResult.add(Requester(id, name))
                    }
                    return dataResult
                }
            }
        }
    }
    // this function used for validation of creating ticket
    private fun getCategory(): MutableList<Category>{
        DBConfig().connection().use {con ->
            con.prepareStatement(getCategory).use {
                it.executeQuery().use { dataset ->
                    val dataResult = mutableListOf<Category>()
                    while (dataset.next()){
                        val id = dataset.getInt("category_id")
                        val name = dataset.getString("category_name")

                        dataResult.add(Category(id, name))
                    }
                    return dataResult
                }
            }
        }
    }
    //this function create for displaying to front side
    fun getLiveNestedCategory(category:String): MutableList<NestedCategory>{
        DBConfig().connection().use { con ->
            con.prepareStatement(getLiveCategory).use {
                it.setString(1, category)
                it.executeQuery().use { dataSet ->
                    val dataResult = mutableListOf<NestedCategory>()
                    while (dataSet.next()){
                        val id = dataSet.getInt("category_id")
                        val name = dataSet.getString("category_name")

                        dataResult.add(NestedCategory(id, name, getNestedSubCategory(id)))
                    }
                    return dataResult
                }
            }
        }
    }
    fun getNestedCategory(): MutableList<NestedCategory>{
        DBConfig().connection().use { con ->
            con.prepareStatement(getCategory).use {
                it.executeQuery().use { dataSet ->
                    val dataResult = mutableListOf<NestedCategory>()
                    while (dataSet.next()){
                        val id = dataSet.getInt("category_id")
                        val name = dataSet.getString("category_name")
                        dataResult.add(NestedCategory(id, name, getNestedSubCategory(id)))
                    }
                    return dataResult
                }
            }
        }
    }

     private fun getNestedSubCategory(categoryId: Int): MutableList<NestedSubCategory>{
         DBConfig().connection().use { con ->
             con.prepareStatement(getNestedSubCategory).use {
                 it.setInt(1, categoryId)
                 it.executeQuery().use { dataResult ->
                     val subCategoryData = mutableListOf<NestedSubCategory>()
                     while (dataResult.next()){
                         val subCategory = dataResult.getString("sub_category_name")
                         val subCategoryId = dataResult.getInt("sub_category_id")
                         val departmentId = dataResult.getInt("assign_department_id")
                         val assignDepartmentName = dataResult.getString("assign_department_name")

                         subCategoryData.add(NestedSubCategory(subCategory, subCategoryId, departmentId, assignDepartmentName))
                     }
                     return subCategoryData
                 }
             }
         }
    }
    // end function for displaying to front side
    private fun getSubCategory(): MutableList<SubCategory>{
        DBConfig().connection().use { con ->
            con.prepareStatement(getSubCategory).use {
                it.executeQuery().use { dataset ->
                    val dataResult = mutableListOf<SubCategory>()
                    while (dataset.next()){
                        val relationId = dataset.getInt("category_id_relation")
                        val id = dataset.getInt("sub_category_id")
                        val name = dataset.getString("sub_category_name")
                        val departmentRelation = dataset.getInt("assign_department_id")

                        dataResult.add(SubCategory(relationId, id, name, departmentRelation))
                    }
                    return dataResult
                }
            }
        }
    }

    fun getDepartment(): MutableList<Department>{
        DBConfig().connection().use { con ->
            con.prepareStatement(getAssignedDepartment).use {
                it.executeQuery().use { dataset ->
                    val dataResult = mutableListOf<Department>()
                    while (dataset.next()){
                        val id = dataset.getInt("assigned_department_id")
                        val name = dataset.getString("assign_department_name")

                        dataResult.add(Department(id, name))
                    }
                    return dataResult
                }
            }
        }
    }

    fun getLiveDepartment(departmentName: String): MutableList<Department>{
        DBConfig().connection().use { con ->
            con.prepareStatement(getLiveAssignedDepartment).use {
                it.setString(1, departmentName)
                it.executeQuery().use { dataset ->
                    val dataResult = mutableListOf<Department>()
                    while (dataset.next()){
                        val id = dataset.getInt("department_id")
                        val name = dataset.getString("department_name")

                        dataResult.add(Department(id, name))
                    }
                    return dataResult
                }
            }
        }
    }

    private fun getArea(): MutableList<AreaRoom>{
        DBConfig().connection().use { con ->
            con.prepareStatement(getAreaLoc).use {
                it.executeQuery().use { dataset ->
                    val dataResult = mutableListOf<AreaRoom>()
                    while (dataset.next()){
                        val relationId = dataset.getInt("floor_id_relation")
                        val id = dataset.getInt("area_loc_id")
                        val name = dataset.getString("area_loc_name")

                        dataResult.add(AreaRoom(relationId, id, name))
                    }
                    return dataResult
                }
            }
        }
    }
    /*
    * this public function for get Area are for displaying to front side
    * */
    fun getAllArea(): MutableList<LiveAreaRoom>{
        DBConfig().connection().use { con ->
            con.prepareStatement(getAllLiveAreaLoc).use {
                it.executeQuery().use { dataset ->
                    val dataResult = mutableListOf<LiveAreaRoom>()
                    while (dataset.next()){
                        val relationId = dataset.getString("floor_name")
                        val floorId = dataset.getInt("floor_id")
                        val areaId = dataset.getInt("area_loc_id")
                        val name = dataset.getString("area_loc_name")

                        dataResult.add(LiveAreaRoom(relationId, floorId, areaId, name))
                    }
                    return dataResult
                }
            }
        }
    }
    fun getLiveArea(area: String): MutableList<LiveAreaRoom>{
        DBConfig().connection().use { con ->
            con.prepareStatement(getLiveAreaLoc).use {
                it.setString(1, area)
                it.executeQuery().use { dataset ->
                    val dataResult = mutableListOf<LiveAreaRoom>()
                    while (dataset.next()){
                        val relationId = dataset.getString("floor_name")
                        val floorId = dataset.getInt("floor_id")
                        val areaId = dataset.getInt("area_loc_id")
                        val name = dataset.getString("area_loc_name")

                        dataResult.add(LiveAreaRoom(relationId, floorId, areaId, name))
                    }
                    return dataResult
                }
            }
        }
    }
    /*
    * end for getting area
    * */
    private fun getFloor(): MutableList<FloorArea>{
        DBConfig().connection().use { con ->
            con.prepareStatement(getDestination).use {
                it.executeQuery().use { dataset ->
                    val dataResult = mutableListOf<FloorArea>()
                    while (dataset.next()){

                        val id = dataset.getInt("floor_id")
                        val name = dataset.getString("floor_name")

                        dataResult.add(FloorArea(id, name))
                    }
                    return dataResult
                }
            }
        }
    }

    fun getReportVia(): MutableList<GetReportedVia>{
        DBConfig().connection().use { con ->
            con.prepareStatement(reportedViaQuery).use {
                it.executeQuery().use { dataset ->
                    val dataResult = mutableListOf<GetReportedVia>()
                    while (dataset.next()){
                        val id = dataset.getInt("reported_via_id")
                        val name = dataset.getString("reported_via_name")

                        dataResult.add(GetReportedVia(id, name))
                    }
                    return dataResult
                }
            }
        }
    }

     fun getLiveReportVia(reportedVia: String): MutableList<GetReportedVia>{
        DBConfig().connection().use { con ->
            con.prepareStatement(liveReportedViaQuery).use {
                it.setString(1, reportedVia)
                it.executeQuery().use { dataset ->
                    val dataResult = mutableListOf<GetReportedVia>()
                    while (dataset.next()){
                        val id = dataset.getInt("reported_via_id")
                        val name = dataset.getString("reported_via_name")

                        dataResult.add(GetReportedVia(id, name))
                    }
                    return dataResult
                }
            }
        }
    }

    private fun getAssign(): MutableList<GetAssign>{
        DBConfig().connection().use { con ->
            con.prepareStatement(assignToQuery).use {
                it.executeQuery().use { dataset ->
                    val dataResult = mutableListOf<GetAssign>()
                    while (dataset.next()){
                        val id = dataset.getInt("assign_to_id")
                        val userId = dataset.getString("user_id")
                        val fName = dataset.getString("assign_to_name")
                        val lName = dataset.getString("assign_to_lastname")
                        val name = "$lName, $fName"
                        dataResult.add(GetAssign(id, userId, name))
                    }
                    return dataResult
                }
            }
        }
    }

    fun getAllLiveAssign(departmentId: Int): MutableList<GetAssign>{
        DBConfig().connection().use { con ->
            con.prepareStatement(liveAllAssignToQuery).use {
                it.setInt(1, departmentId)
                it.executeQuery().use { data ->
                    val dataResult = mutableListOf<GetAssign>()
                    while (data.next()){
                        val id = data.getInt("department_id")
                        val userId = data.getString("user_id")
                        val fName = data.getString("first_name")
                        val lName = data.getString("last_name")
                        val name = "$lName, $fName"
                        dataResult.add(GetAssign(id, userId, name))
                    }
                    return dataResult
                }
            }
        }
    }

    fun getLiveAssign(departmentId: Int, name: String): MutableList<GetAssign>{
        DBConfig().connection().use { con ->
            con.prepareStatement(liveAssignToQuery).use {
                it.setInt(1, departmentId)
                it.setString(2, name)
                it.setString(3,name)
                it.setInt(4, departmentId)
                it.executeQuery().use { data ->
                    val dataResult = mutableListOf<GetAssign>()
                    while (data.next()){
                        val id = data.getInt("department_id")
                        val userId = data.getString("user_id")
                        val fName = data.getString("first_name")
                        val lName = data.getString("last_name")
                        val name = "$lName, $fName"
                        dataResult.add(GetAssign(id, userId, name))
                    }
                    return dataResult
                }
            }
        }
    }

    fun getCoAssign(assignId: Int): MutableList<CoAssign>{
        DBConfig().connection().use { con ->
            con.prepareStatement(coAssignToQuery).use {
                it.setInt(1, assignId)
                it.executeQuery().use { dataset ->
                    val dataResult = mutableListOf<CoAssign>()
                    while (dataset.next()){
                        val id = dataset.getInt("assign_to_id")
                        val userId = dataset.getString("user_id")
                        val fName = dataset.getString("assign_to_name")
                        val lName = dataset.getString("assign_to_lastname")
                        val name = "$lName, $fName"
                        dataResult.add(CoAssign(id, userId, name))
                    }
                    return dataResult
                }
            }
        }
    }

    /*
    * end function getting all dataset from db
    *
    * here start function for checking all input data in create ticket form
    * insert data if not exist
    * get the final dataset
    * */

    fun insertDescription(descriptionData: String, ticketId:String){
        DBConfig().connection().use { con ->
            con.prepareStatement(insertDescription).use {
                it.setString(1, ticketId)
                it.setString(2, descriptionData)
                it.executeUpdate()
            }
        }
    }
    fun findAllInputs (
        requester: String,
        toSupport: String,
        assignTo: String
    ) {
         getRequester().find {
             it.requesterId == requester
         } ?: insertRequester(requester)
         getRequester().find {
             it.requesterId == toSupport
         } ?: insertRequester(toSupport)

        if (assignTo.isNotEmpty()){
            getAssign().find {
                it.userId == assignTo
            } ?: insertAssign(assignTo)
        }

    }

    /*
    * start checking or insertion into DB*/
    private fun insertRequester(requesterId: String){
        DBConfig().connection().use {
            it.prepareStatement(insertRequester).use {
                val userResult = getUser().find { dataResult ->
                    dataResult.userId == requesterId
                }
                val name = nameSeparator(userResult!!.userName)
                name.map {data ->
                    val fName = data.fName.capitalize()
                    val lName = data.lName.capitalize()
                    val userId = userResult!!.userId

                    it.setString(1, fName)
                    it.setString(2, lName)
                    it.setString(3, userId)
                    it.executeUpdate()
                }
            }
        }
    }
    private fun insertCategory(category: String){
        DBConfig().connection().use {
            it.prepareStatement(insertCategory).use { data ->
                data.setString(1, category)
                data.executeUpdate()
            }
        }
    }


    fun findInsertSubCategory(subCategory: String, categoryId: Int, departmentId: Int){
        getSubCategory().find {
            it.subCategoryName == subCategory
        }?: insertSubCategory(subCategory, categoryId, departmentId)
        updateSubCategory(subCategory, categoryId, departmentId)
    }
    private fun insertSubCategory(subCategory: String, categoryId: Int, departmentId: Int){
        DBConfig().connection().use {
            it.prepareStatement(insertSubCategory).use { data ->
                data.setString(1, subCategory)
                data.setInt(2, categoryId)
                data.setInt(3, departmentId)
                data.executeUpdate()
            }
        }
    }

    private fun updateSubCategory(subCategory: String, categoryId: Int, departmentId: Int){
        DBConfig().connection().use {
            it.prepareStatement(updateSubCategory).use { data ->
                data.setInt(1, departmentId)
                data.setInt(2, categoryId)
                data.setString(3, subCategory)
                data.executeUpdate()
            }
        }
    }
    private fun insertFloor(floor: String){
        DBConfig().connection().use {
            it.prepareStatement(insertDestination).use{ data ->
                data.setString(1, floor)
                data.executeUpdate()
            }
        }
    }
    private fun insertArea(area: String, floor: String){
        DBConfig().connection().use {
            it.prepareStatement(insertAreaLocation).use { data ->
                val floorResult = getFloor().find { data ->
                    data.floorName == floor
                }
                data.setString(1, area)
                data.setInt(2, floorResult!!.floorId)
                data.executeUpdate()
            }
        }
    }
    private fun insertReportedVia(reportedVia: String){
        DBConfig().connection().use {
            it.prepareStatement(insertReportedViaQuery).use { data ->
                data.setString(1, reportedVia)
                data.executeUpdate()
            }
        }
    }
    private fun insertAssign(userId: String){
        DBConfig().connection().use {
            it.prepareStatement(insertAssignToQuery).use {
                val userResult = getUser().find { dataResult ->
                    dataResult.userId == userId
                }
                val assign = nameSeparator(userResult!!.userName)
                assign.map { data ->
                    val fName = data.fName.capitalize()
                    val lName = data.lName.capitalize()

                    it.setString(1, fName)
                    it.setString(2, lName)
                    it.setString(3, userResult!!.userId)
                    it.executeUpdate()
                }
            }
        }
    }
    private fun nameSeparator(name: String): MutableList<SplitName>{
        val nameData = mutableListOf<SplitName>()
        val newName = name.split(", ").toTypedArray()
        nameData.add(SplitName(newName[0], newName[1]))

        return nameData
    }
    fun getIdCounter(): String{
        DBConfig().connection().use { con ->
            con.prepareStatement(getTicketCount).use {
                it.executeQuery().use { dataSet ->
                    var counter = 1
                    while (dataSet.next()){
                        counter += 1
                    }
                    return counter.toString()
                }
            }
        }
    }

}