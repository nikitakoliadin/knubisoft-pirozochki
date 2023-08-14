package com.knubisoft.application.user;


import com.knubisoft.application.user.User;
import com.knubisoft.application.user.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/user/change-email", method = RequestMethod.PATCH)
    public @ResponseBody ResponseEntity<?> changeEmail(Principal principal, @RequestBody String email) {
        User user = defaultUserService.findByUsername(principal.getName());
        defaultUserService.updateEmail(user, email);
        return ResponseEntity.ok(user);
    }

}
