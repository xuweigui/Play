package com.windrift.controller;


import com.windrift.model.entity.Employees;
import com.windrift.security.spring.WdRoles;
import com.windrift.security.spring.WdUserDetail;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Gary Xu
 */
@Controller
@RequestMapping("/welcome")
public class HomeController {
    private static final Log LOGGER = LogFactory.getLog(HomeController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public String execute(Model model) {
        LOGGER.debug("something");

        Employees employee = ((WdUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmployees();

        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(WdRoles.ADMIN)) {
            model.addAttribute("deptNo", employee.getCurrentDepartment().getDeptNo());
            return "/userlist";
        } else {
            model.addAttribute("employee", employee);
            return "/userdetail";
        }
    }
}