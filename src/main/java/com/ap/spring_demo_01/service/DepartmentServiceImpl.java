package com.ap.spring_demo_01.service;

import com.ap.spring_demo_01.entity.Department;
import com.ap.spring_demo_01.errors.DepartmentNotFoundException;
import com.ap.spring_demo_01.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional <Department> department  = departmentRepository.findById(departmentId);
        if(department.isEmpty()){
            throw new DepartmentNotFoundException("No such Department");
        }
        return department.get();
    }

    @Override
    public String deleteDepartmentById(Long departmentId) {
        String massage = "deletion process failed.";
        try{
            departmentRepository.deleteById(departmentId);
            massage = "Successfully deleted.";
        }catch (Exception e){
            System.out.println(e);
        }

        return massage;
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) throws DepartmentNotFoundException {

        Optional <Department> oldDepartment = departmentRepository.findById(departmentId);

        if(oldDepartment.isEmpty()){
            throw new DepartmentNotFoundException("No such department");
        }


        if(Objects.nonNull(department.getDepartmentName()) && !"".equals(department.getDepartmentName()) ){
            oldDepartment.get().setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equals(department.getDepartmentCode()) ){
            oldDepartment.get().setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equals(department.getDepartmentAddress()) ){
            oldDepartment.get().setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(oldDepartment.get());
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
