package com.simplilearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.model.Product;
import com.simplilearn.model.User;
import com.simplilearn.service.ProductService;
import com.simplilearn.service.UserService;
import com.simplilearn.util.ProductPager;
import com.simplilearn.util.UserPager;

import java.security.Principal;
import java.util.Optional;

@Controller
public class ManageUsersController {
    
    private static final int INITIAL_PAGE = 0;

    private final UserService userService;

    @Autowired
    public ManageUsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/manageUsers")
    public ModelAndView home(@RequestParam("page") Optional<Integer> page) {

        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<User> users = userService.findAllUsersPageable(new PageRequest(evalPage, 5));
        UserPager pager = new UserPager(users);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", users);
        modelAndView.addObject("pager", pager);
        modelAndView.setViewName("/manageUsers");
        return modelAndView;
    }

}