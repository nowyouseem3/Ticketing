package get.models

import kotlinx.serialization.Serializable
import javax.security.auth.Destroyable

@Serializable
data class GetFloor(
    val floorId: Int,
    val floorName: String,
): Destroyable

@Serializable
data class GetAreaLocation(
    val floorIdRelation: Int,
    val areaLocationId: Int,
    val areaLocationName: String
): Destroyable

