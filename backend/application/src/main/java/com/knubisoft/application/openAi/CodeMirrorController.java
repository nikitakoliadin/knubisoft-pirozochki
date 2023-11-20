package com.knubisoft.application.openAi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codemirror")
@RequiredArgsConstructor
public class CodeMirrorController {
    private final CodeMirrorService codeMirrorService;

    @PostMapping("/code")
    public ResponseEntity<CodeMirrorResponse> generateCode(@RequestBody final String request) {
        String code = codeMirrorService.generateCode(request);
        CodeMirrorResponse codeMirrorResponse = codeMirrorService.createCodeMirrorResponse(code);
        return ResponseEntity
                .status(codeMirrorResponse.getStatusCode())
                .body(codeMirrorResponse);
    }
}
