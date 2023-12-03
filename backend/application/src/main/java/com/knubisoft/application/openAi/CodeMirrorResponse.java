package com.knubisoft.application.openAi;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
public class CodeMirrorResponse {
    private int statusCode;
    private List<String> suggestions;
}
