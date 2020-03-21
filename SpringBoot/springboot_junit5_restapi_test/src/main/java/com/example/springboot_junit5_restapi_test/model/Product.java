package com.example.springboot_junit5_restapi_test.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.math.BigDecimal;

public class Product {

    private Integer id;
    private String productName;
    private BigDecimal price;

    public Product(Integer id, String productName, Double price ){
        this.productName = productName;
        this.price=new BigDecimal(price);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = new BigDecimal(price);
    }

    @Override
    public String toString() {
        return "ProductList [id=" + id + ", productName=" + productName + ", price=" + price  + "]";
    }



}
