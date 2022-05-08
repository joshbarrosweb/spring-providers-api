package com.joshbarros.springproviders.controllers;

import com.joshbarros.springproviders.entities.User;
import com.joshbarros.springproviders.exception.UserNotFoundException;
import com.joshbarros.springproviders.repositories.UserRepository;
import com.joshbarros.springproviders.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid User user) {
        try {
            userService.save(user);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
