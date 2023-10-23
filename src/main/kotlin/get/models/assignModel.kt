package get.models

import kotlinx.serialization.Serializable
import javax.security.auth.Destroyable

@Serializable
data class GetAssignTo(
    val assignToId: Int,
    val assignToName: String
): Destroyable

@Serializable
data class GetCoAssignTo(
    val coAssignId: Int,
    val coAssignName: String
): Destroyable