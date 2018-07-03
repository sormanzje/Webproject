/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.webproject.repository;

import com.david.webproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author tothda
 */
public interface UserRepository extends JpaRepository<User, Long>{
    
    User findByEmail(String email);
}
