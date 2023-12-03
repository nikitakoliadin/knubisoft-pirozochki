package com.knubisoft.application.openAi;

import com.knubisoft.application.exception.CodeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.client.OpenAiClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class CodeMirrorServiceImpl implements CodeMirrorService {
    private final OpenAiClient openAiClient;

    @Override
    public CodeMirrorResponse generateCodeSuggestions(final CodeMirrorRequest request) {
        String modifiedPrompt = String.format(CodeMirrorConstants.MODIFY_PROMPTS,
                request.getLanguage(), request.getPrompt());
        String openAiResponse = getOpenAiResponse(modifiedPrompt);
        List<String> codeSuggestions = extractExamples(openAiResponse, request.getLanguage());
        return buildCodeMirrorResponse(codeSuggestions);
    }

    private String getOpenAiResponse(final String prompt) {
        return openAiClient.generate(prompt);
    }

    private List<String> extractExamples(final String response, final String language) {
        List<String> examples = new ArrayList<>();
        Pattern pattern = Pattern.compile(
                "Example \\d+:.*?```" + language.toLowerCase() + "\\n(.*?)```", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        while (matcher.find()) {
            examples.add(matcher.group(1).trim());
        }
        if (examples.isEmpty()) {
            throw new CodeNotFoundException();
        }
        return examples;
    }

    private CodeMirrorResponse buildCodeMirrorResponse(final List<String> codeSuggestions) {
        CodeMirrorResponse codeMirrorResponse = new CodeMirrorResponse();
        codeMirrorResponse.setStatusCode(HttpStatus.OK.value());
        codeMirrorResponse.setSuggestions(codeSuggestions);
        return codeMirrorResponse;
    }
}
