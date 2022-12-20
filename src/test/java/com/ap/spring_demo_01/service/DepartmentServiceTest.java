package com.ap.spring_demo_01.service;

import com.ap.spring_demo_01.controller.DepartmentController;
import com.ap.spring_demo_01.entity.Department;
import com.ap.spring_demo_01.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {
    private static Logger logger = LoggerFactory.getLogger(DepartmentServiceTest.class);

    @Autowired
    DepartmentService departmentService;

    @MockBean
    DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentId(1L)
                .departmentAddress("Kilinochi")
                .departmentName("Information Technology")
                .departmentCode("IT").build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Information Technology"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("When valid department name is provide department object should return")
    public void whenValidDepartmentNameProvide_DepartmentShouldFetch(){
        String departmentName = "Information Technology";
        Department found = departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }

    @Test
    @DisplayName("When invalid department name is provide department not found exception should return return")
    public void whenInvalidDepartmentNameProvide_DepartmentShouldNotFetch(){

        String departmentName = "Technology";
        Department found = departmentService.getDepartmentByName(departmentName);
        logger.info("============================================================================ ");
        logger.info("object ", found);
        assertNull(found);
    }
}