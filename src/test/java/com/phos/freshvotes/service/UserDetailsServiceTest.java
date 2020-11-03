package com.phos.freshvotes.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Folarin on 04/09/2020
 */
public class UserDetailsServiceTest {

    @Test
    public void test(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String rawPassword = "P@$$w0rd@ALAT";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println(encodedPassword);

        Assert.assertNotEquals(rawPassword,encodedPassword);
    }
}
