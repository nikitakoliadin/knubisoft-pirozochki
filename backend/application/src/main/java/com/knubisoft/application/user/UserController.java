package com.knubisoft.application.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    private DefaultUserService defaultUserService;

    @Autowired
    public UserController(DefaultUserService defaultUserService) {
        this.defaultUserService = defaultUserService;
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<?> createUser(@RequestBody User user) {
        if (defaultUserService.userExist(user.getUsername())) {
            return new ResponseEntity<>(null, null, HttpStatus.CONFLICT);
        }
        defaultUserService.create(user);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.PATCH)
    public @ResponseBody ResponseEntity<?> updateUser(@RequestBody User user, Principal principal) {
        try {
            defaultUserService.updateUser(user, principal);
        } catch (Exception e) {
            return new ResponseEntity<>(e, null, HttpStatus.NOT_MODIFIED);
        }
        return ResponseEntity.noContent().build();
    }
}
