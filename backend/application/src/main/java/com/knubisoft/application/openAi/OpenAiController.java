package com.knubisoft.application.openAi;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.client.OpenAiClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openAi")
@RequiredArgsConstructor
public class OpenAiController {

    private final OpenAiClient aiClient;

    @PostMapping("/prompt")
    public ResponseEntity<String> generateAnswer(@RequestBody final String prompts) {
        return ResponseEntity.ok(aiClient.generate(prompts));
    }
}
