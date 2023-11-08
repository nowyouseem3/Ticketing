package get.models

import kotlinx.serialization.Serializable
import javax.security.auth.Destroyable

@Serializable
data class GetDescription(
    val descriptionId: Int,
    val descriptionVal: String
):Destroyable

