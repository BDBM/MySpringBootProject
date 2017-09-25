package com.misl.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService _departmentService;

    @RequestMapping("/departments")
    public List<Department> getAllDepartments(){
        return _departmentService.getAllDepartments();
    }

    @RequestMapping("/departments/{id}")
    public Department getDepartmentByName(@PathVariable int id){
        return _departmentService.getDepartmentById(id);
    }

    @RequestMapping(method=RequestMethod.POST,value="/departments")
    public void addDepartment(@RequestBody Department dept){
        _departmentService.addDepartment(dept);
    }

    @RequestMapping(method=RequestMethod.PUT,value="/departments/{id}")
    public void updateDepartment(@RequestBody Department dept,@PathVariable int id){
        _departmentService.updateDepartment(id, dept);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/departments/{id}")
    public void deleteDepartment(@PathVariable int id){
        _departmentService.deleteDepartment(id);
    }

}