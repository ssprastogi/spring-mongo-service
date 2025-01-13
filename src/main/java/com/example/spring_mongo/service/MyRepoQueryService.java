package com.example.spring_mongo.service;

import com.example.spring_mongo.domain.Department;
import com.example.spring_mongo.domain.Employee;
import com.example.spring_mongo.repository.DepartmentQueryRepository;
import com.example.spring_mongo.repository.EmployeeQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyRepoQueryService {
    private final EmployeeQueryRepository employeeQueryRepository;
    private final DepartmentQueryRepository departmentQueryRepository;


    @Autowired
    public MyRepoQueryService(EmployeeQueryRepository employeeQueryRepository, DepartmentQueryRepository departmentQueryRepository) {
        this.employeeQueryRepository = employeeQueryRepository;
        this.departmentQueryRepository = departmentQueryRepository;
    }


    public List<Employee> getAllEmp() {
        return employeeQueryRepository.findAll();
    }

    public Employee getEmpById(String id) {
        return employeeQueryRepository.findEmployeeById(id);
    }

    public Employee addEmp(Employee empObj) {
        return employeeQueryRepository.save(empObj);
    }

    public Employee updateEmp(String id, Employee updatedEmp) {
        Employee currentEmp = employeeQueryRepository.findById(id).orElseThrow();
        currentEmp.setName(updatedEmp.getName());
        currentEmp.setAge(updatedEmp.getAge());
        currentEmp.setGender(updatedEmp.getGender());
        return employeeQueryRepository.save(currentEmp);
    }
/*
    public List<Department> getAllDept() {

        return departmentQueryRepository.findAll();
    }

    public Department addDept(Department deptObj) {

        return departmentQueryRepository.save(deptObj);
    }

    public Department getDeptById(String id) {
        return departmentQueryRepository.findById(id).orElseThrow();
    }*/


}
