package com.knubisoft.application.openAi;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CodeMirrorRequest {

    @NotBlank(message = "Language cannot be empty or null")
    @Pattern(regexp = "^(?i)(java|groovy|kotlin)$", message = "Language must be one of: java, groovy, kotlin")
    private String language;

    @NotBlank(message = "Prompt cannot be empty or null")
    private String prompt;
}
