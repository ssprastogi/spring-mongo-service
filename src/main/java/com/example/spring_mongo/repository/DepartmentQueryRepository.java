package com.example.spring_mongo.repository;

import com.example.spring_mongo.domain.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentQueryRepository extends MongoRepository<Department, String> {
}
