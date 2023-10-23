package get.models

import kotlinx.serialization.Serializable
import javax.security.auth.Destroyable

@Serializable
data class GetReportedVia(
    val reportedViaId: Int,
    val reportedViaDetails: String
): Destroyable