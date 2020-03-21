package com.example.springboot_junit5_restapi_test.controller;

import com.example.springboot_junit5_restapi_test.model.Product;
import com.example.springboot_junit5_restapi_test.repository.ListRepository;
import com.example.springboot_junit5_restapi_test.services.ListService;
import com.example.springboot_junit5_restapi_test.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    ListService listService;
    @Autowired
    ProductService productService;


    @GetMapping("/hello")
    public String hello() {
        return "Hello Controller";
    }

    @GetMapping("/list")
    public List<String> getAll() {
        return listService.getAll();
    }


    @GetMapping(path = "/products", produces = "application/json")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping(value = "/products/{id}")
    public Product getProduct(@PathVariable("id") int id){
        return productService.getAllProducts().get(id);
    }


    @PostMapping(path = "/products", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Product product) throws Exception{
        Integer id = productService.getAllProducts().size()+1;
        product.setId(id);
        productService.addProduct(product);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/updateProduct/{id}", consumes = "application/json", produces = "application/json")
    public void updateEmployee(@PathVariable("id") Integer id, @RequestBody Product product){
        Product prod = productService.getProduct(id);
        prod.setProductName(product.getProductName());
        prod.setPrice(product.getPrice().doubleValue());
        productService.addProduct(prod);
    }

    @DeleteMapping(value="/deleteProduct/{id}")
    public Product deleteProduct(@PathVariable("id") int id){
        return productService.getAllProducts().remove(id-1);
    }

}
