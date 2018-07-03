/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.webproject.service;

import com.david.webproject.controller.dto.UserRegistrationDto;
import com.david.webproject.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author tothda
 */
public interface UserService extends UserDetailsService{
    
    User findByEmail(String email);
    
    User save(UserRegistrationDto registration);
    
}
