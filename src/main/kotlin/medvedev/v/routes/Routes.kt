package medvedev.v.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import medvedev.v.Detour
import medvedev.v.PrintFile


fun Route.routs() {
    route("/say") {
        get {
            call.respondText("Hello!", status = HttpStatusCode.OK)
        }
    }

    route("") {
        var name: String
        get {
            name = call.parameters["name"].toString()
            call.respondText("Hello, $name", status = HttpStatusCode.OK)
        }
    }
    route("/{directory}") {
        get {
            val detour = Detour()
            val res = detour.showAllFiles(call.parameters["directory"].toString())
            if (res == "") {
                call.respondText("No such directory", status = HttpStatusCode.NotFound)
            } else {
                call.respondText(res, status = HttpStatusCode.OK)
            }
        }
    }
    route("/{directory?}/{filename?}") {
        get {
            val printFile = PrintFile()
            val res: String =
                printFile.printFile(call.parameters["directory"].toString(), call.parameters["filename"].toString())
            call.respondText(res, status = HttpStatusCode.OK)
        }
    }

}
