package com.windrift.controller;


import com.windrift.model.entity.Employees;
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
                String deptNo = employee.getCurrentDepartment().getDeptNo();
                model.addAttribute("deptNo", deptNo);
                return "/userlist";
            }
            else {
                model.addAttribute("employee", employee);
                return "/userdetail";
            }
        }
        else {
            model.addAttribute("errorMsg", "Username or password not correct");
            model.addAttribute("username", username);
            return "login";
        }
    }
}
