package com.ap.spring_demo_01.repository;

import com.ap.spring_demo_01.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
 public Department findByDepartmentNameIgnoreCase(String departmentName);
}
