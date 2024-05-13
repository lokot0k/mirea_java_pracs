package demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import demo.services.UserService;
import lombok.AllArgsConstructor;
import demo.entities.User;

@RestController
@AllArgsConstructor
public class AuthController {
    private UserService service;

    @PostMapping("/registration")
    public void createUser(@RequestBody User user) {
        service.createUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        return "Login successful";
    }
}
