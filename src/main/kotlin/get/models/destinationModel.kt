package get.models

import kotlinx.serialization.Serializable
import javax.security.auth.Destroyable

@Serializable
data class Floor(
    val floorId: Int,
    val floorName: String,
): Destroyable

@Serializable
data class Area(
    val floorIdRelation: Int,
    val areaLocationId: Int,
    val areaLocationName: String
): Destroyable

