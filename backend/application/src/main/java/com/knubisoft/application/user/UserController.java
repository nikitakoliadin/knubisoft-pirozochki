package com.knubisoft.application.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    private final DefaultUserService defaultUserService;

    @Autowired
    public UserController(final DefaultUserService defaultUserService) {
        this.defaultUserService = defaultUserService;
    }

    @PatchMapping(value = "/user/create")
    public @ResponseBody ResponseEntity<?> createUser(@RequestBody final User user) {
        if (defaultUserService.userExist(user.getUsername())) {
            return new ResponseEntity<>(null, null, HttpStatus.CONFLICT);
        }
        defaultUserService.create(user);
        return ResponseEntity.ok(user);
    }

    @PatchMapping(value = "/user/update")
    public @ResponseBody ResponseEntity<?> updateUser(@RequestBody final User user, final Principal principal) {
        try {
            defaultUserService.updateUser(user, principal);
        } catch (Exception e) {
            return new ResponseEntity<>(e, null, HttpStatus.NOT_MODIFIED);
        }
        return ResponseEntity.noContent().build();
    }
}
