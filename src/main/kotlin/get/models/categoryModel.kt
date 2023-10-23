package get.models

import kotlinx.serialization.Serializable
import javax.security.auth.Destroyable

@Serializable
data class GetCategory(
    val categoryId: Int,
    val categoryName: String,
    val subCategoryData: MutableList<GetSubCategory>
): Destroyable

@Serializable
data class GetSubCategory(
    val categoryId: Int,
    val subCategoryId: Int,
    val subCategoryName: String
): Destroyable

@Serializable
data class GetAssignedDepartment(
    val assignedDepartmentId: Int,
    val subCategoryId: Int,
    val assignedDepartmentName: String
): Destroyable


@Serializable
data class GenericResponse<out T>(
    var text: String = "",
    var code: Int = 0,
    val data: T
): Destroyable