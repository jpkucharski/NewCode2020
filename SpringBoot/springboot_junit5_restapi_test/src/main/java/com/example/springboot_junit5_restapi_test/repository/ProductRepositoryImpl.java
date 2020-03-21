package com.example.springboot_junit5_restapi_test.repository;

import com.example.springboot_junit5_restapi_test.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {


    private static List<Product> productList;

    {
        fillProductList();
    }

    private static void fillProductList() {
        if (productList == null) {
            productList = new ArrayList<Product>();
        }
        productList.add(new Product(1,"Product1", 2.15));
        productList.add(new Product(2,"Product2", 7.00));
        productList.add(new Product(3,"Product3", 12.99));

    }

    @Override
    public List<Product> getAll() {
        return productList;
    }
}
