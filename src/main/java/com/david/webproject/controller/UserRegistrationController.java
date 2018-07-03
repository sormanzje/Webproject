/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.webproject.controller;

import com.david.webproject.service.UserService;
import com.david.webproject.controller.dto.UserRegistrationDto;
import com.david.webproject.model.User;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tothda
 */

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    
    @Autowired
    private UserService userService;
    
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }
    
    @GetMapping
    public String showRegistrationForm(Model model){
        return "registration";
    }
    
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userRegistrationDto, BindingResult result){
        User existing = userService.findByEmail(userRegistrationDto.getEmail());
        if(existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        
        if(result.hasErrors()){
            return "registration";
        }
        
        userService.save(userRegistrationDto);
        return "redirect:/registration?success";
    }
}
