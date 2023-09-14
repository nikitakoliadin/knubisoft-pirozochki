package com.knubisoft.application.about;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AboutController {
    private final AboutService aboutService;

    @GetMapping("/about")
    public ResponseEntity<List<About>> findAll() {
        return ResponseEntity.ok(aboutService.findAll());
    }
}
