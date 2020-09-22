package com.phos.freshvotes.service;

import com.phos.freshvotes.Entity.Product;
import com.phos.freshvotes.Entity.User;
import com.phos.freshvotes.exceptions.ProductServiceException;
import com.phos.freshvotes.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * Created by Folarin on 22/09/2020
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(User user){
        Product product = new Product();

        product.setPublished(false);
        product.setUser(user);

        return productRepository.save(product);

    }

    @Override
    public Product getProduct(Long id) throws ProductServiceException {

        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isPresent()){
            return productOptional.get();
        }else{
            throw new ProductServiceException("Product with Id  "+ id +" was not found");
        }
    }
}
