package com.phos.freshvotes.repositories;

import com.phos.freshvotes.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Folarin on 02/09/2020
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
