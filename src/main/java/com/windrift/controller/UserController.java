package com.windrift.controller;


import com.windrift.model.entity.Employees;
import com.windrift.model.dto.EmployeeForList;
import com.windrift.model.dto.EmployeeResultDTO;
import com.windrift.model.dto.EmployeeSearchCondition;
import com.windrift.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
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
/*
    @RequestMapping("/dept/{deptNo}")
    public String displayAllUserInDepartment(@PathVariable("deptNo") String deptNo, Model model) {
        List<Employees> employees = userService.getEmployeesBy(deptNo);
        model.addAttribute("employees", employees);
        return "userlist";
    }*/


    @RequestMapping(value="/json")
    @ResponseBody
    public EmployeeResultDTO getEmployeeInDept(@RequestParam("deptNo") String deptNo,
                                               @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                                               @RequestParam(value = "firstName", required = false) String firstName,
                                               @RequestParam(value = "lastName", required = false) String lastName,
                                               @RequestParam(value = "gender", required = false) Character gender) {

        EmployeeSearchCondition filter = new EmployeeSearchCondition();
        filter.setDeptNo(deptNo);
        filter.setCurrentPage(currentPage);
        filter.setFirstName(firstName);
        filter.setLastName(lastName);
        filter.setGender(gender);
        filter.setTotal(userService.getTotalBy(filter));
        List<Employees> employees = userService.getEmployeesBy(filter);
        List<EmployeeForList> rtn = new ArrayList<>(employees.size());
        for (Employees e : employees)
            rtn.add(new EmployeeForList(e));

        return new EmployeeResultDTO(filter, rtn);
//        return JsonUtil.getJsonForUserList(employees);
    }
}
