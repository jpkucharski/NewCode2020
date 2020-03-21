package com.example.springboot_junit5_restapi_test.controller;

import com.example.springboot_junit5_restapi_test.model.Product;
import com.example.springboot_junit5_restapi_test.repository.ProductRepository;
import com.example.springboot_junit5_restapi_test.services.ListService;
import com.example.springboot_junit5_restapi_test.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.CoreMatchers.*;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MainControllerTest {

    @Autowired
    private ObjectMapper jsonMapper;

    @Autowired
    protected MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @Mock
    private ListService listService;


    @InjectMocks
    private MainController mainController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void hello() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/hello").toString(), String.class);
        assertEquals("Hello Controller", response.getBody());
    }

    @Test
    public void getAll() throws Exception{
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(new URL("http://localhost:"+port+"/").toString(),String.class);
        assertEquals("200 OK", responseEntity.getStatusCode().toString());
    }

    @Test
    public void getAllProducts() throws Exception{

        List<Product> mockedListOfProducts = Arrays.asList(new Product(1,"productName_1", 2.05));
        when(productService.getAllProducts()).thenReturn(mockedListOfProducts);

        assertThat(mainController.getAllProducts().get(0).getProductName().equals(mockedListOfProducts.get(0).getProductName()));
    }

    @Test
    public void getAllFromList() throws Exception{
        List<String> mockedListOfStrings = Arrays.asList("TestString1","TestString2","TestString3");
        when(listService.getAll()).thenReturn(mockedListOfStrings);

        assertIterableEquals(mainController.getAll(), mockedListOfStrings);
    }

//    @Test
//    public void addProductToProductList() throws Exception{
//
//        Product testProduct1 = new Product(1,"testProduct1", 10.10);
//        Product testProduct2 = new Product(2,"testProduct2", 20.20);
//
//        List<Product> testProductsList = Arrays.asList(testProduct1,testProduct2);
//        System.out.println("Before: "+testProductsList.size());
//        when(productService.getAllProducts()).thenReturn(testProductsList);
//
//        Product testProduct3 = new Product(3,"testProduct3", 30.30);
//
//
//        MvcResult result = mockMvc.perform(post("http://localhost:8080/products")
//                .contentType("application/json")
//                .content(jsonMapper.writeValueAsString(testProduct3)))
//                .andExpect(status().isCreated())
//                .andReturn();
//        System.out.println("After: "+testProductsList.size());
//
//        Product productAfterTest = jsonMapper.readValue(result.getResponse().getContentAsByteArray(), Product.class);
//
//        System.out.println(productAfterTest.getProductName());
//        Mockito.when(
//                studentService.addCourse(Mockito.anyString(),
//                        Mockito.any(Course.class))).thenReturn(mockCourse);

//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post("/students/Student1/courses")
//                .accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
//                .contentType(MediaType.APPLICATION_JSON);

//            ResponseEntity<String> responseEntity = restTemplate.getForEntity(new URL("http://localhost:"+port+"/").toString(),String.class);
//            assertEquals("200 OK", responseEntity.getStatusCode().toString());
//        }


    }

