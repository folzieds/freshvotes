package com.phos.freshvotes.service;

import com.phos.freshvotes.Entity.Product;
import com.phos.freshvotes.Entity.User;
import com.phos.freshvotes.exceptions.ProductServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Folarin on 22/09/2020
 */

@Service
public interface ProductService {

    Product create(User user);

    Product getProduct(Long id) throws ProductServiceException;

    Product update(Long id, Product product) throws ProductServiceException;

    List<Product> getProductByUsername(User user);
}
