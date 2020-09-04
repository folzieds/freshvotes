package com.phos.freshvotes.security;

import com.phos.freshvotes.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Set;

/**
 * Created by Folarin on 03/09/2020
 */
public class CustomSecurityUser extends User implements UserDetails {

    public CustomSecurityUser(){}


    public CustomSecurityUser(User user) {
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setId(user.getId());
        this.setName(user.getName());
        this.setAuthorities(user.getAuthorities());
    }

    @Override
    public Set<Authority> getAuthorities() {
        return this.getAuthorities();
    }

    @Override
    public String getPassword() {
        return this.getPassword();
    }

    @Override
    public String getUsername() {
        return this.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
