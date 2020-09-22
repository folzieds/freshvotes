package com.phos.freshvotes.repositories;

import com.phos.freshvotes.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Folarin on 22/09/2020
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
}
