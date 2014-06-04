package com.windrift.controller;


import com.windrift.model.Employees;
import com.windrift.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Gary Xu
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());
    @Resource
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public String execute(@RequestParam("username") String username,
                          @RequestParam("password") String password, Model model) {
        LOGGER.log(Level.FINER, "something");

        Employees employee = userService.getEmployee(password);
        if (employee != null && (employee.getFirstName() + "." + employee.getLastName()).equals(username)) {
            if (employee.isManager()) {
                return "forward:/user/dept/" + employee.getCurrentDepartment().getDeptNo();
            }
            else {
                model.addAttribute("employee", employee);
                return "/userdetail";
            }
        }
        else
            return "index";
    }
}
