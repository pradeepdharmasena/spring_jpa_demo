package com.ap.spring_demo_01.controller;

import com.ap.spring_demo_01.entity.Department;
import com.ap.spring_demo_01.errors.DepartmentNotFoundException;
import com.ap.spring_demo_01.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        logger.info("post method fired");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> allDepartments(){

        return departmentService.fetchAll();
    }

    @GetMapping("/dep")
    public Department getDepartmentById(@RequestParam(value = "id", required = false) Long departmentId) throws DepartmentNotFoundException{
        System.out.println("Department getDepartmentById controller " + departmentId);
        logger.info("get method fired", + departmentId);
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/departments")
    public String deleteDepartmentById(@RequestParam(value = "id", required = false) Long departmentId){
        System.out.println("Department getDepartmentById controller " + departmentId);
        logger.info("get method fired", + departmentId);
        return departmentService.deleteDepartmentById(departmentId);
    }


    @PutMapping("/departments")
    public Department updateDepartmentById(@RequestParam(value = "id") Long departmentId,
                                       @RequestBody Department department

    ) throws DepartmentNotFoundException {
        return departmentService.updateDepartmentById(departmentId, department);
    }

    @GetMapping("/departments/name")
    public Department getDepartmentByName(@RequestParam(value = "name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }
}
