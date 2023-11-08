package get

import get.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 3000, host = "192.168.4.134"){
        module()
    }.start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
    configureHTTP()
}
