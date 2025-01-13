package com.example.spring_mongo.service;

import com.example.spring_mongo.domain.Department;
import com.example.spring_mongo.domain.Employee;
import com.example.spring_mongo.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyTemplateService {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public MyTemplateService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Employee> getAllEmp() {
        return mongoTemplate.findAll(Employee.class);
    }

    public Employee getEmpById(String id) {
        return mongoTemplate.findById(id, Employee.class);
    }

    public Employee addEmp(Employee empObj) {
        return mongoTemplate.save(empObj);
    }

    public Employee updateEmp(String id, Employee updatedEmp) {
        Employee currentEmp = mongoTemplate.findOne(
                Query.query(Criteria.where("id").is(id)), Employee.class);
        if (null == currentEmp) {
            throw new CustomException("Record not found");
        }
        currentEmp.setName(updatedEmp.getName());
        currentEmp.setAge(updatedEmp.getAge());
        currentEmp.setGender(updatedEmp.getGender());
        return mongoTemplate.save(currentEmp);
    }

    public List<Department> getAllDept() {

        return mongoTemplate.findAll(Department.class);
    }

    public Department addDept(Department deptObj) {

        return mongoTemplate.save(deptObj);
    }

    public Department getDeptById(String id) {
        return mongoTemplate.findById(id, Department.class);
    }

}
