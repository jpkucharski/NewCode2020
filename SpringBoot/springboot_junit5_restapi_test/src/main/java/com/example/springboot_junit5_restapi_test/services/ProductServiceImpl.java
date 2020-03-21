package com.example.springboot_junit5_restapi_test.services;

import com.example.springboot_junit5_restapi_test.model.Product;
import com.example.springboot_junit5_restapi_test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    ProductRepository productRepository;


    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAll();
    }

    @Override
    public Product getProduct(int id) {
        return productRepository.getAll().get(id-1);
    }

    @Override
    public void addProduct(Product p) {
        productRepository.getAll().add(p);
    }
}
