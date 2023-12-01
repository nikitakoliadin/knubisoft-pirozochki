package com.knubisoft.application.openAi;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CodeMirrorRequest {
    private ProgrammingLanguage language;
    private String prompt;
}
