package com.misl.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository _courseRepository;

    public List<Course> getAllCourses(int departmetnId){
        List<Course> courses=new ArrayList<>();
        _courseRepository.findByDepartmentId(departmetnId).forEach(courses :: add);
        return courses;
    }

    public Course getCourse(int id){
        return _courseRepository.findOne(id);
    }

    public void addCourse(Course course){
        _courseRepository.save(course);
    }

    public void updateCourse(Course course){
        _courseRepository.save(course);
    }

    public void deleteCourse(int id){
        _courseRepository.delete(id);
    }

}