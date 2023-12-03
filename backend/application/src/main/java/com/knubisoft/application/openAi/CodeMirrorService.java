package com.knubisoft.application.openAi;

public interface CodeMirrorService {
    CodeMirrorResponse generateCodeSuggestions(CodeMirrorRequest request);
}
