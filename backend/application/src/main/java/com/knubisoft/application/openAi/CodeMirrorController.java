package com.knubisoft.application.openAi;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.client.OpenAiClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/codemirror")
@RequiredArgsConstructor
public class CodeMirrorController {
    private final OpenAiClient openAiClient;

    @PostMapping("/code")
    public ResponseEntity<CodeMirrorResponse> generateCode(@RequestBody final String request) {
        String openAiClientResponse = openAiClient.generate(request);
        String code = extractCode(openAiClientResponse);
        CodeMirrorResponse codeMirrorResponse = new CodeMirrorResponse();
        codeMirrorResponse.setCode(code);
        return ResponseEntity.ok(codeMirrorResponse);
    }

    public String extractCode(String response) {
        Pattern pattern = Pattern.compile("```\\w*\\n(.*?)\\n```", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "No code found";
    }
}
