package com.misl.department;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DeptInfo")
public class Department {

    @Id
    @GeneratedValue
    private int id;
    private String deptCode;
    private String deptName;

    public Department(){

    }

    public Department(int id, String deptCode, String deptName) {
        super();
        this.id = id;
        this.deptCode = deptCode;
        this.deptName = deptName;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDeptCode() {
        return deptCode;
    }
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }










}
