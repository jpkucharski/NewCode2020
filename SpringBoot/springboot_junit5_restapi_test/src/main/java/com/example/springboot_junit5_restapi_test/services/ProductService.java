package com.example.springboot_junit5_restapi_test.services;

import com.example.springboot_junit5_restapi_test.model.Product;

import java.util.List;

public interface ProductService{

    public List<Product> getAllProducts();

    public Product getProduct(int id);

    public void addProduct(Product p);
}
