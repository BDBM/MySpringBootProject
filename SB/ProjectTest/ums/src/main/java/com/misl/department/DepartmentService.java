package com.misl.department;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository _departmentRepository;

    public List<Department> getAllDepartments(){
        List<Department> departments=new ArrayList<>();
        _departmentRepository.findAll().forEach(departments :: add);
        return departments;
    }

    public Department getDepartmentById(int id){
        return _departmentRepository.findOne(id);
    }

    public void addDepartment(Department dept){
        if(dept.getDeptCode()==null){
            // "Department Code Required";
        }
        if(dept.getDeptName()==null){
            // "Department Name Required";
        }
        if(dept!=null){
            _departmentRepository.save(dept);
        }
    }

    public void updateDepartment(int id,Department dept){
        _departmentRepository.save(dept);
    }

    public void deleteDepartment(int id){
        _departmentRepository.delete(id);
    }




}
