package com.windrift.security.spring;

import com.windrift.model.entity.Employees;
import com.windrift.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by gary on 29/08/14.
 */
public class WdUserDetailService implements UserDetailsService {

    private static final Log logger = LogFactory.getLog(WdUserDetailService.class.getName());
    private UserService userService;

    public WdUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.debug("get user detail for: " + s);
        if (s == null) return null;
        String[] names = s.split(".");
        if (names.length != 2) return null;
        Employees e = userService.getEmployeeByName(names[0], names[1]);
        return new User(s, e.getEmpNo(), null);
    }
}
