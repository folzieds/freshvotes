package com.phos.freshvotes.service;

import com.phos.freshvotes.Entity.Product;
import com.phos.freshvotes.Entity.User;
import com.phos.freshvotes.exceptions.ProductServiceException;
import com.phos.freshvotes.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

/**
 * Created by Folarin on 22/09/2020
 */

@Service
public class ProductServiceImpl implements ProductService {

    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

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
        logger.info("Searchign for product with Id " + id);
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isPresent()){
            logger.info("Product found...");
            return productOptional.get();
        }else{
            throw new ProductServiceException("Product with Id  "+ id +" was not found");
        }
    }

    @Override
    public Product getProduct(String name) throws ProductServiceException {

        try {
            logger.info("Decoding URL...");
            String decode = URLDecoder.decode(name, StandardCharsets.UTF_8.name());
            Optional<Product> productOptional = productRepository.findByName(decode);
            if(productOptional.isPresent()){
                logger.info("Product found with name " + productOptional.get().getName());
                return productOptional.get();
            }else{
                throw new ProductServiceException(name +" was not found");
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("Could not decode URL ",e);
        }
        return new Product();
    }

    @Override
    public Product update(Long id, Product product) throws ProductServiceException {
        try {
            logger.info("Attempting product update...");
            Product tempProduct = getProduct(id);
            tempProduct.setName(product.getName());
            tempProduct.setPublished(product.getPublished());
            logger.info("Product details updating to DB...");
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