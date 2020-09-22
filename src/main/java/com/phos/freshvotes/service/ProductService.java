package com.phos.freshvotes.service;

import com.phos.freshvotes.Entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by Folarin on 22/09/2020
 */

@Service
public interface ProductService {
    boolean create(User user);
}
