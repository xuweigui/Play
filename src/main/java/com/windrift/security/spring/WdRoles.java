package com.windrift.security.spring;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by gary on 1/09/14.
 */
public enum WdRoles implements GrantedAuthority {
    USER("USER"), ADMIN("ADMIN");
    private final String role;

    WdRoles(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
