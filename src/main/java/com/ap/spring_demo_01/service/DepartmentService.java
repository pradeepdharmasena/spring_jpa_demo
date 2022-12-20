package com.ap.spring_demo_01.service;

import com.ap.spring_demo_01.entity.Department;
import com.ap.spring_demo_01.errors.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
     Department saveDepartment(Department department);

     List<Department> fetchAll();

     Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    String deleteDepartmentById(Long departmentId);

    Department updateDepartmentById(Long departmentId, Department department) throws DepartmentNotFoundException;

    Department getDepartmentByName(String departmentName);
}
