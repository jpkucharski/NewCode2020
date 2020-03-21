package com.jpk.rest_demo.dao;

import com.jpk.rest_demo.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeDAO extends CrudRepository<Employee, Integer> {

}
