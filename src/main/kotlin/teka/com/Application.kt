package teka.com

import io.ktor.server.application.*
import teka.com.plugins.configureRouting
import teka.com.plugins.configureSerialization

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
}
