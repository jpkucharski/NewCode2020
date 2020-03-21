package com.example.springboot_junit5_restapi_test.repository;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ListRepositoryImpl implements ListRepository{
    @Override
    public List<String> getAll() {

        return Arrays.asList("String1","String2","String3");
    }
}
