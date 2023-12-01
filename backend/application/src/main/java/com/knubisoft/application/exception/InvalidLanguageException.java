package com.knubisoft.application.exception;

import com.knubisoft.application.openAi.CodeMirrorConstants;

public class InvalidLanguageException extends RuntimeException {
    public InvalidLanguageException() {
        super(CodeMirrorConstants.INVALID_LANGUAGE_MESSAGE);
    }
}
