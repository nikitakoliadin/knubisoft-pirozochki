package com.knubisoft.application.openAi.sse;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/codemirror")
public class OpenAISseController {

    private final OpenAISseService openAISseService;

    public OpenAISseController(OpenAISseService openAISseService) {
        this.openAISseService = openAISseService;
    }

    @PostMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> streamOpenAI(@RequestBody String initialMessage) {

        return Flux.create(sink -> {
            // Create a new thread for SSE processing
            new Thread(() -> {
                // Process incoming SSE events and send them to the client
                openAISseService.processSSEEvents(
                        chunk -> sink.next(ServerSentEvent.builder(chunk).build()), initialMessage);

                // Complete the Flux when SSE connection is closed
                sink.complete();
            }).start();
        });
    }
}
