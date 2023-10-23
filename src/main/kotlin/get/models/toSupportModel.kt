package get.models

import kotlinx.serialization.Serializable
import javax.security.auth.Destroyable

@Serializable
data class GetToSupport(
    val toSupportID: Int,
    val toSupportName: String
): Destroyable