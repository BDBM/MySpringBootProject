package com.misl.course;

import com.misl.department.Department;
import com.misl.semister.Semister;

import javax.persistence.*;

@Entity
@Table(name="CourseInfo")
public class Course {

    @Id
    @GeneratedValue
    private int id;
    private String code;
    private String name;
    private double credit;
    private String description;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Semister semister;




    public Course(){

    }

    public Course(int id, String code, String name, double credit, String description,int departmentId,int semisterId) {
        super();
        this.id = id;
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.description = description;
        this.department=new Department(departmentId,"","");
        this.semister=new Semister(semisterId,"");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Semister getSemister() {
        return semister;
    }

    public void setSemister(Semister semister) {
        this.semister = semister;
    }


}