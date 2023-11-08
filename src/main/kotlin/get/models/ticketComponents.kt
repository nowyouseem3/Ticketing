package get.models

import kotlinx.serialization.Serializable
import javax.security.auth.Destroyable

@Serializable
data class UserInfo(
    val userId: String,
    val userName: String
): Destroyable

@Serializable
data class UserInfoLive(
    val userId: String,
    val userName: String
): Destroyable

@Serializable
data class Requester(
    val requesterId: String,
    val requesterName: String
): Destroyable


@Serializable
data class Category(
    val categoryId: Int,
    val categoryName: String
): Destroyable

@Serializable
data class NestedCategory(
    val categoryId: Int,
    val categoryName: String,
    val subCategory: MutableList<NestedSubCategory>
):Destroyable


@Serializable
data class NestedSubCategory(
    val subCategory: String,
    val subCategoryId: Int,
    val departmentId: Int,
    val department: String
)

@Serializable
data class SubCategory(
    val categoryId: Int,
    val subCategoryId: Int,
    val subCategoryName: String,
    val departmentId: Int
): Destroyable

@Serializable
data class SubCategoryResponse(
    val categoryId: Int,
    val subCategoryName: String,
    val departmentId: Int
)

@Serializable
data class Department(
    val departmentId: Int,
    val departmentName: String
):Destroyable

@Serializable
data class FloorArea(
    val floorId: Int,
    val floorName: String,
): Destroyable

@Serializable
data class AreaRoom(
    val floorIdRelation: Int,
    val areaLocationId: Int,
    val areaLocationName: String
): Destroyable

@Serializable
data class LiveAreaRoom(
    val floorName: String,
    val floorId: Int,
    val areaId: Int,
    val areaLocationName: String
): Destroyable

@Serializable
data class GetReportedVia(
    val reportedViaId: Int,
    val reportedViaDetails: String
): Destroyable

@Serializable
data class GetAssign(
    val assignToId: Int,
    val userId: String,
    val assignToName: String,
): Destroyable

@Serializable
data class CoAssign(
    val assignToId: Int,
    val userId: String,
    val assignToName: String,
): Destroyable

@Serializable
data class CreateTicketFunction(
    val requester: String,
    val toSupport: String,
    val category: Int,
    val subCategory: Int,
    val reportedVia: Int,
    val floor: Int,
    val areaLoc: Int,
    val assignDepartment: Int,
    val assignTo: String,
    val status: Int
): Destroyable

@Serializable
data class SplitName(
    val lName: String,
    val fName: String
): Destroyable


@Serializable
data class GenericResponse<out S>(
    val text: String = "",
    val code: Int = 0,
    val data: S
): Destroyable