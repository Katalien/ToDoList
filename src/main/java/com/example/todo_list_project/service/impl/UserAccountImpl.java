package com.example.todo_list_project.service.impl;
import com.example.todo_list_project.dao.UserAccount;
import com.example.todo_list_project.dto.UserAccountDto;
import com.example.todo_list_project.repository.UserAccountRepository;
import com.example.todo_list_project.service.Converter;
import com.example.todo_list_project.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UserAccountImpl implements UserAccountService {
    @Autowired
    UserAccountRepository repos;

    @Autowired
    Converter converter;

    @Override
    public UserAccountDto getUserByEmail(String email){
        if(email != null) {
            UserAccount user = repos.findByEmail(email).orElse(null);
            if(user == null){
                return null;
            }
            return converter.convertToUserDto(user);
        }
        else{
            return null;
        }
    }

    @Override
    public UserAccountDto addUser(OAuth2User principal){
        UserAccount user = new UserAccount();
        user.setName(principal.getAttribute("name"));
        user.setEmail(principal.getAttribute("email"));
        repos.saveAndFlush(user);
        return converter.convertToUserDto(user);
    }
}
