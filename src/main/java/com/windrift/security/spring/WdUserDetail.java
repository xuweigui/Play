package com.windrift.security.spring;

import com.windrift.model.entity.Employees;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by gary on 1/09/14.
 */
public class WdUserDetail extends User {
    private Employees employees;

    public WdUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}
