package com.phos.freshvotes.service;

import com.phos.freshvotes.Entity.Product;
import com.phos.freshvotes.Entity.User;
import com.phos.freshvotes.exceptions.ProductServiceException;
import com.phos.freshvotes.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public Product update(Long id, Product product) throws ProductServiceException {
        try {
            Product tempProduct = getProduct(id);
            tempProduct.setName(product.getName());
            tempProduct.setPublished(product.getPublished());
            return productRepository.save(tempProduct);
        } catch (ProductServiceException e) {
            throw new ProductServiceException("Product with Id" + id + " could not be updated");
        }
    }

    @Override
    public List<Product> getProductByUsername(User user) {
        return productRepository.findByUser(user);
    }
}
