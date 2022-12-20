package com.ap.spring_demo_01.repository;

import com.ap.spring_demo_01.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;


    @BeforeEach
    void setUp() {

        Department department = Department.builder()
                .departmentName("Computer Engineering")
                .departmentAddress("Jaffna")
                .departmentCode("CE").build();

        testEntityManager.persist(department);

    }

    @Test
    public void whenFindById_thenReturnDepartment(){
        Department found = departmentRepository.findById(1L).get();
        assertEquals(found.getDepartmentId(), 1L);
    }
}