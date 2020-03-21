package com.jpk.rest_demo.controller;

import com.jpk.rest_demo.dao.EmployeeDAO;
import com.jpk.rest_demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/v01")
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDao;

    @GetMapping(path = "")
    public String getApiVersion(){
        return "api v0.1: for employees: /employees, for the rest /employees/{id}";
    }



    @GetMapping(path = "/employees")
    public Iterable<Employee> getEmployees() {
        return employeeDao.findAll();
    }

    @GetMapping(path = "/employees/{id}")
    public Optional<Employee> getEmployee(@PathVariable("id") int id){
            return employeeDao.findById(id);
    }

    @PostMapping(value="/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        Employee emp = employeeDao.save(employee);
        return emp;
    }

    @PutMapping(value="/employees/{id}")
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee){
            Optional<Employee> employeeToUpdate = employeeDao.findById(id);
            Employee newEmp = new Employee();
            employeeToUpdate.ifPresent(consumer -> {
                newEmp.setId(id);
                newEmp.setFirstName(employee.getFirstName());
                newEmp.setLastName(employee.getLastName());
                newEmp.setEmail(employee.getEmail());
            });
            return employeeDao.save(newEmp);
    }

    @DeleteMapping(value = "/employees/{id}")
    public void deleteEmployee(@PathVariable("id") int id){
        employeeDao.deleteById(id);

    }

}