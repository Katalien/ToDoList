package com.example.todo_list_project.service;

import com.example.todo_list_project.dao.UserAccount;
import com.example.todo_list_project.dto.UserAccountDto;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface UserAccountService {
    UserAccountDto getUserByEmail(String email);

    UserAccountDto addUser(OAuth2User principal);
}
