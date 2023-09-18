package com.knubisoft.application.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserRepositoryRestController {

    @Autowired
    private DefaultUserService defaultUserService;

    @GetMapping("/users")
    public @ResponseBody ResponseEntity<?> listUsers() {
        return ResponseEntity.ok(defaultUserService.findAll());
    }

    @PatchMapping(value = "/user/change-email")
    public @ResponseBody ResponseEntity<?> changeEmail(final Principal principal, @RequestBody final String email) {
        User user = defaultUserService.findByUsername(principal.getName());
        defaultUserService.updateEmail(user, email);
        return ResponseEntity.ok(user);
    }
}
