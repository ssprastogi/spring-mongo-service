package com.example.spring_mongo.service;

import com.example.spring_mongo.domain.Department;
import com.example.spring_mongo.domain.Employee;
import com.example.spring_mongo.repository.DepartmentRepository;
import com.example.spring_mongo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyRepoService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public MyRepoService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Employee> getAllEmp() {
        return employeeRepository.findAll();
    }

    public Employee getEmpById(String id) {
        return employeeRepository.findById(id)
                .orElseThrow();
    }

    public Employee addEmp(Employee empObj) {
        return employeeRepository.save(empObj);
    }

    public Employee updateEmp(String id, Employee updatedEmp) {
        Employee currentEmp = employeeRepository.findById(id).orElseThrow();
        currentEmp.setName(updatedEmp.getName());
        currentEmp.setAge(updatedEmp.getAge());
        currentEmp.setGender(updatedEmp.getGender());
        return employeeRepository.save(currentEmp);
    }

    public List<Department> getAllDept() {

        return departmentRepository.findAll();
    }

    public Department addDept(Department deptObj) {

        return departmentRepository.save(deptObj);
    }

    public Department getDeptById(String id) {
        return departmentRepository.findById(id).orElseThrow();
    }


}
