package com.windrift.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;

/**
 * Created by Gary Xu
 */
@Controller
public class HomeController {

    @RequestMapping(value="/")
    public String home () {
        return "login";
    }
}
