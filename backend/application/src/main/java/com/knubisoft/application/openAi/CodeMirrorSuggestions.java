package com.knubisoft.application.openAi;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CodeMirrorSuggestions {
    private String firstSuggestion;
    private String secondSuggestion;
    private String thirdSuggestion;
}
