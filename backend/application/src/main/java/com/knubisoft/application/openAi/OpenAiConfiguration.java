package com.knubisoft.application.openAi;

import com.theokanning.openai.service.OpenAiService;
import org.springframework.ai.openai.client.OpenAiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class OpenAiConfiguration {
    private static final Integer MINUTES = 5;
    private static final Double TEMPERATURE = 0.5;

    @Value("${spring.ai.openai.api-key}")
    private String openAiToken;

    @Bean
    public OpenAiService openAiService() {
        return new OpenAiService(openAiToken, Duration.ofMinutes(MINUTES));
    }

    @Bean
    public OpenAiClient openAiClient(final OpenAiService aiService) {
        OpenAiClient aiClient = new OpenAiClient(aiService);
        aiClient.setTemperature(TEMPERATURE);
        return aiClient;
    }
}
