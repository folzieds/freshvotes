package com.phos.freshvotes.repositories;

import com.phos.freshvotes.Entity.Product;
import com.phos.freshvotes.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Folarin on 22/09/2020
 */
public interface ProductRepository extends JpaRepository<Product,Long>{

    List<Product> findByUser(User user);
}
