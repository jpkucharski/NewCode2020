package com.jpk.rest_demo.controller;

import com.jpk.rest_demo.dao.EmployeeDAO;
import com.jpk.rest_demo.model.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



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








import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    private static Employee testEmployee1, testEmployee2;

    @Autowired
    protected MockMvc mockMvc;
    private static Iterable<Employee> mockedEmployeeList;

    @Mock
    private EmployeeDAO employeeDAO;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeAll
    public static void setUp(){
        testEmployee1 = new Employee();
        testEmployee1.setId(1);
        testEmployee1.setFirstName("fName1");
        testEmployee1.setLastName("lName1");
        testEmployee1.setEmail("email1");
        testEmployee2 = new Employee();
        testEmployee2.setId(2);
        testEmployee2.setFirstName("fName2");
        testEmployee2.setLastName("lName2");
        testEmployee2.setEmail("email2");
        mockedEmployeeList = Arrays.asList(testEmployee1,testEmployee2);
    }

    @Test
    public void getAllEmployees_ShouldReturnListOfAllEmployees(){
        when(employeeDAO.findAll()).thenReturn(mockedEmployeeList);
        assertThat(employeeDAO.findAll().equals(mockedEmployeeList));
    }

}