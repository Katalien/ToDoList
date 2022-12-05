package com.example.todo_list_project.controller;
import com.example.todo_list_project.dto.UserAccountDto;
import com.example.todo_list_project.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserAccountService service;

    @GetMapping("/users")
    public UserAccountDto getUser(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            return null;
        }
        else {
            if(service.getUserByEmail(principal.getAttribute("email")) == null){
                service.addUser(principal);
            }
            UserAccountDto userDto= service.getUserByEmail(principal.getAttribute("email"));
            return userDto;
        }
    }
}
