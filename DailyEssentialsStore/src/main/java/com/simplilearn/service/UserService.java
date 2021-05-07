package com.simplilearn.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.simplilearn.model.Product;
import com.simplilearn.model.User;

public interface UserService {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
    
    Page<User> findAllUsersPageable(Pageable pageable);

    User saveUser(User user);

}
