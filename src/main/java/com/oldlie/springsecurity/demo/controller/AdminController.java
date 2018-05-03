package com.oldlie.springsecurity.demo.controller;

import com.oldlie.springsecurity.demo.domain.User;
import com.oldlie.springsecurity.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService service) {
        this.userService = service;
    }

    /**
     * 查询所用用户
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model) {

        List<User> list = this.userService.listUsers();
        model.addAttribute("title", "管理员管理");
        model.addAttribute("userList", list);
        return new ModelAndView("users/list", "userModel", model);
    }
}
