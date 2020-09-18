package com.phos.freshvotes.service;

import com.phos.freshvotes.Entity.User;
import com.phos.freshvotes.repositories.UserRepository;
import com.phos.freshvotes.security.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Folarin on 18/09/2020
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User save(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Authority authority = new Authority();
        authority.setAuthority("ROLE_USER");
        authority.setUser(user);

        user.getAuthorities().add(authority);

        return userRepository.save(user);
    }

}
