package medvedev.v.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import medvedev.v.routes.routs

fun Application.configureRouting() {

    routing {
        routs()
    }
}
