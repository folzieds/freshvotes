package com.phos.freshvotes.security;

import com.phos.freshvotes.Entity.User;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by Folarin on 03/09/2020
 */
@Entity
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Authority;
    @ManyToOne
    private User user;

    @Override
    public String getAuthority() {
        return this.Authority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        Authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
