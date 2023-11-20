package com.knubisoft.application.openAi;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.client.OpenAiClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.knubisoft.application.openAi.CodeMirrorConstants.NO_CODE_FOUND_MESSAGE;
import static com.knubisoft.application.openAi.CodeMirrorConstants.NO_CODE_SUGGESTION;

@Service
@RequiredArgsConstructor
public class CodeMirrorServiceImpl implements CodeMirrorService {
    private final OpenAiClient openAiClient;

    @Override
    public String generateCode(final String request) {
        String openAiResponse = openAiClient.generate(request);
        return extractCode(openAiResponse);
    }

    @Override
    public CodeMirrorResponse createCodeMirrorResponse(final String code) {
        CodeMirrorResponse codeMirrorResponse = new CodeMirrorResponse();
        if (code.equals(NO_CODE_FOUND_MESSAGE)) {
            codeMirrorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            codeMirrorResponse.setSuggestions(NO_CODE_SUGGESTION);
        } else {
            codeMirrorResponse.setStatusCode(HttpStatus.OK.value());
            codeMirrorResponse.setSuggestions(code);
        }
        return codeMirrorResponse;
    }

    public String extractCode(final String response) {
        Pattern pattern = Pattern.compile("```\\w*\\n(.*?)\\n```", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return NO_CODE_FOUND_MESSAGE;
    }
}
