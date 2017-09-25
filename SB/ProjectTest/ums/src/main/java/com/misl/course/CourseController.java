package com.misl.course;
import com.misl.department.Department;
import com.misl.semister.Semister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/departments/{departmentId}/courses")
    public List<Course> getAllCourses(@PathVariable int departmentId){
        return courseService.getAllCourses(departmentId);
    }

    @RequestMapping("/departments/{departmentId}/courses/{id}")
    public Course getCourse(@PathVariable int id){
        return courseService.getCourse(id);
    }

    @RequestMapping(method=RequestMethod.POST,value="/departments/{departmentId}/courses/semisters/{semisterId}")
    public void addCourse(@RequestBody Course course, @PathVariable int departmentId,@PathVariable int semisterId){
        course.setDepartment(new Department(departmentId,"",""));
        course.setSemister(new Semister(semisterId,""));
        courseService.addCourse(course);
    }

    @RequestMapping(method=RequestMethod.PUT,value="/departments/{departmentId}/courses/{id}/semisters/{semisterId}")
    public void updateCourse(@RequestBody Course course,@PathVariable int departmentId,@PathVariable int id,@PathVariable int semisterId){
        course.setDepartment(new Department(departmentId,"",""));
        course.setSemister(new Semister(semisterId,""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/departments/{departmentId}/courses/{id}/semisters/{semisterId}")
    public void deleteCourse(@PathVariable int id){
        courseService.deleteCourse(id);
    }

}
