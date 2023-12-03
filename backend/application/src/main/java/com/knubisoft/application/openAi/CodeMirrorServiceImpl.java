package com.knubisoft.application.openAi;

import com.knubisoft.application.exception.CodeNotFoundException;
import com.knubisoft.application.exception.InvalidLanguageException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.EnumUtils;
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
    private final int suggestionAmount = 3;

    @Override
    public CodeMirrorResponse generateCodeSuggestions(final CodeMirrorRequest request) {
        validateLanguage(request);
        String modifiedPrompt = String.format(CodeMirrorConstants.MODIFY_PROMPTS,
                request.getLanguage(), request.getPrompt());
        String openAiResponse = getOpenAiResponse(modifiedPrompt);
        CodeMirrorSuggestions codeSuggestions = extractCodeExamples(openAiResponse, request.getLanguage());
        return buildCodeMirrorResponse(codeSuggestions);
    }

    private void validateLanguage(final CodeMirrorRequest request) {
        if (request.getLanguage() == null
                || !EnumUtils.isValidEnum(ProgrammingLanguage.class, request.getLanguage().name())) {
            throw new InvalidLanguageException();
        }
    }

    private String getOpenAiResponse(final String prompt) {
        return openAiClient.generate(prompt);
    }

    private CodeMirrorSuggestions extractCodeExamples(final String response, final ProgrammingLanguage language) {
        List<String> examples = extractExamples(response, language);
        if (examples.size() < suggestionAmount) {
            throw new CodeNotFoundException();
        }
        return buildCodeSuggestions(examples);
    }

    private List<String> extractExamples(final String response, final ProgrammingLanguage language) {
        List<String> examples = new ArrayList<>();
        Pattern pattern = Pattern.compile(
                "Example \\d+:.*?```" + language.name().toLowerCase() + "\\n(.*?)```", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        while (matcher.find()) {
            examples.add(matcher.group(1).trim());
        }
        return examples;
    }

    private CodeMirrorSuggestions buildCodeSuggestions(final List<String> examples) {
        CodeMirrorSuggestions codeSuggestions = new CodeMirrorSuggestions();
        codeSuggestions.setFirstSuggestion(examples.get(0));
        codeSuggestions.setSecondSuggestion(examples.get(1));
        codeSuggestions.setThirdSuggestion(examples.get(2));
        return codeSuggestions;
    }

    private CodeMirrorResponse buildCodeMirrorResponse(final CodeMirrorSuggestions codeSuggestions) {
        CodeMirrorResponse codeMirrorResponse = new CodeMirrorResponse();
        codeMirrorResponse.setStatusCode(HttpStatus.OK.value());
        codeMirrorResponse.setSuggestions(codeSuggestions);
        return codeMirrorResponse;
    }
}
