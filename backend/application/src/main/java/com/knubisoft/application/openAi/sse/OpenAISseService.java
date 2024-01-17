package com.knubisoft.application.openAi.sse;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import lombok.Getter;
import org.glassfish.jersey.media.sse.EventInput;
import org.glassfish.jersey.media.sse.InboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Getter
@Service
public class OpenAISseService {
    @Value("${spring.ai.openai.api-key}")
    private String openAiToken;
    @Value("${spring.ai.openai.model}")
    private String model;
    @Value("${spring.ai.openai.temperature}")
    private Double temperature;

    public void processSSEEvents(ChunkConsumer chunkConsumer, String initialMessage) {
        Client client = ClientBuilder.newBuilder()
                .register(SseFeature.class)
                .build();

        WebTarget target = client.target("https://api.openai.com/v1/chat/completions");

        EventInput eventInput = target
                .request()
                .header("Authorization", "Bearer " + openAiToken)
                .header("Content-Type", "application/json")
                .accept("text/event-stream")
                .post(jakarta.ws.rs.client.Entity.json(getRequestJson(initialMessage)), EventInput.class);

        while (!eventInput.isClosed()) {
            InboundEvent inboundEvent = eventInput.read();
            if (inboundEvent != null) {
                String chunk = inboundEvent.readData(String.class);
                chunkConsumer.consume(chunk);
            }
        }

        client.close();
    }

    private String getRequestJson(final String initialMessage) {
        return
           String.format("{\"model\": \"%s\", \"messages\": [{\"role\": \"user\", \"content\": \"%s\"}]," +
                           " \"temperature\": %s, \"stream\": true}", model, initialMessage, temperature);
    }

    // Functional interface for consuming chunks
    public interface ChunkConsumer {
        void consume(String chunk);
    }
}
