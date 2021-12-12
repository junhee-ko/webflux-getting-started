package jko.webfluxgettingstarted.hello

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class GreetingClient(builder: WebClient.Builder) {
    private val client: WebClient

    val message: Mono<String>
        get() = client.get().uri("/hello").accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Greeting::class.java)
            .map(Greeting::message)

    init {
        client = builder.baseUrl("http://localhost:8080").build()
    }
}
