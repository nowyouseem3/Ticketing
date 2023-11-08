package get.plugins

import get.routes.TicketRoutes.displayTicketRouting
import get.routes.TicketRoutes.requestTicketRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        displayTicketRouting()
        requestTicketRouting()
    }
}
