package com.knubisoft.application.openAi;

import com.theokanning.openai.service.OpenAiService;
import org.springframework.ai.openai.client.OpenAiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class OpenAiConfiguration {
    @Value("${spring.ai.openai.api-key}")
    private String openAiToken;
    @Value("${spring.ai.openai.duration}")

    private Integer seconds;
    @Value("${spring.ai.openai.temperature}")

    private Double temperature;
    @Value("${spring.ai.openai.model}")

    private String model;

    @Bean
    public OpenAiService openAiService() {
        return new OpenAiService(openAiToken, Duration.ofMinutes(seconds));
    }

    @Bean
    public OpenAiClient openAiClient(final OpenAiService aiService) {
        OpenAiClient aiClient = new OpenAiClient(aiService);
        aiClient.setTemperature(temperature);
        aiClient.setModel(model);
        return aiClient;
    }
}
