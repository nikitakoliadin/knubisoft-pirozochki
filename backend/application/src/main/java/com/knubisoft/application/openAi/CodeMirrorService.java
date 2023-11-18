package com.knubisoft.application.openAi;

public interface CodeMirrorService {
    String generateCode(String request);
    CodeMirrorResponse createCodeMirrorResponse(String code);
}
