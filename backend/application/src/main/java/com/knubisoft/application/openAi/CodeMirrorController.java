package com.knubisoft.application.openAi;

import jakarta.validation.Valid;
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
    public ResponseEntity<Object> generateCode(@Valid @RequestBody final CodeMirrorRequest request) {
        CodeMirrorResponse response = codeMirrorService.generateCodeSuggestions(request);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
