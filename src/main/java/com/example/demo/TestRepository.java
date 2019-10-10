package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TestRepository extends CrudRepository<Test,Long>{
   // ArrayList<Test> findBySubjectContaingIgnoreCase(String subject);
}
