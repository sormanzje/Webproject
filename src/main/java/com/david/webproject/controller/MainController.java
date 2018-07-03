/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.webproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author tothda
 */

@Controller
public class MainController {
    
    @GetMapping("/")
    public String root(){
        return "index";
    }
    
    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }
    
    @GetMapping("/user")
    public String userIndex(){
        return "user/index";
    }
}
