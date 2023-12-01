package com.knubisoft.application.exception;

import com.knubisoft.application.openAi.CodeMirrorConstants;

public class CodeNotFoundException extends RuntimeException {
    public CodeNotFoundException() {
        super(CodeMirrorConstants.NO_CODE_GENERATED_MESSAGE);
    }
}
