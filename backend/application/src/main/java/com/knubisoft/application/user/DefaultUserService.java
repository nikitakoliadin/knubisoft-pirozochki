package com.knubisoft.application.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@Transactional
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DefaultUserService(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean userExist(final String username) {
        return userRepository.findByUsername(username) != null;
    }

    @Override
    public User create(final User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreated(LocalDateTime.now());
        user.setLastModified(LocalDateTime.now());
        userRepository.save(user);
        log.info("User {} saved", user);
        return user;
    }

    @Override
    public void updateUser(User user, Principal principal) {
        User u = userRepository.findByUsername(principal.getName());
        boolean isModified = false;
        if (u == null)
            throw new RuntimeException(String.format("User %s is not found", principal.getName()));
        if (user.getName() != null) {
            u.setName(user.getName());
            isModified = true;
        }
        if (user.getSurname() != null) {
            u.setSurname(user.getSurname());
            isModified = true;
        }
        if (user.getEmail() != null) {
            u.setEmail(user.getEmail());
            isModified = true;
        }

        if (isModified) {
            u.setLastModified(LocalDateTime.now());
            log.info("User Updated {}", u);
        }
    }

    @Override
    public User updateEmail(final User user, final String email) {
        user.setEmail(email);
        log.info("{} email changed to {}", user.getUsername(), email);
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional(readOnly = true)
    public User findById(final Long id) {
        return userRepository.findById(id).get();
    }
}
