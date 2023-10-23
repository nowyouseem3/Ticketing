package get.plugins

import get.routes.requestTicketRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        requestTicketRouting()
    }
}
