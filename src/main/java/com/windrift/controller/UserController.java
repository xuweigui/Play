package com.windrift.controller;


import com.windrift.model.Employees;
import com.windrift.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Gary Xu
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());
    @Resource
    private UserService userService;

    @RequestMapping("/{uid}")
    public String displayUserDetail(@PathVariable("uid") String uid, Model model) {
        Employees employee = userService.getEmployee(uid);
        model.addAttribute("employee", employee);
        return "userdetail";
    }

    @RequestMapping("/dept/{deptNo}")
    public String displayAllUserInDepartment(@PathVariable("deptNo") String deptNo, Model model) {
        List<Employees> employees = userService.getEmployeesByDept(deptNo);
        model.addAttribute("employees", employees);
        return "userlist";
    }
}
