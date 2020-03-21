package com.example.springboot_junit5_restapi_test.repository;

import com.example.springboot_junit5_restapi_test.model.Product;

import java.util.List;

public interface ProductRepository {

    public List<Product> getAll();

}
