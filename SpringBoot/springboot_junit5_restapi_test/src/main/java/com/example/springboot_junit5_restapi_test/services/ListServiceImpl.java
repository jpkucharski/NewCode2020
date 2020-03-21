package com.example.springboot_junit5_restapi_test.services;

import com.example.springboot_junit5_restapi_test.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListServiceImpl implements  ListService{

   @Autowired
    ListRepository listRepository;


    @Override
    public List<String> getAll() {
        return listRepository.getAll();
    }
}
