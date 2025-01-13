package com.example.spring_mongo.controller;

import com.example.spring_mongo.domain.Employee;
import com.example.spring_mongo.service.MyRepoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/query")
public class MyRepoQueryController {
    private final MyRepoQueryService myService;

    @Autowired
    public MyRepoQueryController(MyRepoQueryService myService) {
        this.myService = myService;
    }

    @GetMapping("/allEmployees")
    public List<Employee> fetchAllEmp() {
        return myService.getAllEmp();
    }

    @PostMapping("/emp")
    public Employee addEmp(@RequestBody Employee employee) {
        return myService.addEmp(employee);
    }

    @GetMapping("/emp/{id}")
    public Employee fetchEmpById(@PathVariable String id) {
        return myService.getEmpById(id);
    }

    @PutMapping("/emp/{id}")
    public Employee updateEmpById(@PathVariable String id, @RequestBody Employee employee) {
        return myService.updateEmp(id, employee);
    }
/*

    @GetMapping("/allDepartments")
    public List<Department> fetchAllDept() {
        return myService.getAllDept();
    }


    @PostMapping("/dept")
    public Department addDept(@RequestBody Department department) {
        return myService.addDept(department);
    }

    @GetMapping("/dept/{id}")
    public Department fetchDeptById(@PathVariable String id) {
        return myService.getDeptById(id);
    }*/

}
