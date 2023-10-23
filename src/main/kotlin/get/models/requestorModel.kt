package get.models

import kotlinx.serialization.Serializable
import javax.security.auth.Destroyable

@Serializable
data class GetRequestor(
    val requestorId: Int,
    val requestorName: String
): Destroyable
