package jko.webfluxgettingstarted

import jko.webfluxgettingstarted.hello.GreetingClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    val context: ConfigurableApplicationContext = runApplication<Application>(*args)
    val greetingClient = context.getBean(GreetingClient::class.java)
    val message: String? = greetingClient.message.block()

    println(">> message =  $message")
}
