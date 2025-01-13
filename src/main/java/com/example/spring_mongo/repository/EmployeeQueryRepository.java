package com.example.spring_mongo.repository;

import com.example.spring_mongo.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeQueryRepository extends MongoRepository<Employee, String> {
    //Return all records but id, name and age with value others with null
    @Query(value = "{}", fields = "{'name':1, 'age':1}")
    List<Employee> findAllWithNameAndAgeOnly();

    @Query("{'age':{$gt:20,$lt:30}}")
    List<Employee> findAllWithAgeBetween20And30();

    @Query("{'age':{$nin:[20,22]}}")
    List<Employee> findAllNotInAge20And22();

    @Query("{'age':{$in:[20,22]}}")
    List<Employee> findAllInAge20And22();

    @Query(value = "{}")
    List<Employee> findAll();

    @Query("{'id':?0}")
    Employee findEmployeeById(String id);


}
