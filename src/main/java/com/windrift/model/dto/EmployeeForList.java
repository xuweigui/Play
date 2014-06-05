package com.windrift.model.dto;

import com.windrift.model.entity.Employees;

import java.util.Date;

/**
 * Created by gary on 5/06/14.
 */
public class EmployeeForList {

    private String empNo;
    private String firstName;
    private String lastName;
    private Character gender;
    private String title;
    private Date hireDate;

    public EmployeeForList(Employees e) {
        this.empNo = e.getEmpNo();
        this.firstName = e.getFirstName();
        this.lastName = e.getLastName();
        this.gender = e.getGender();
        this.title = e.getCurrentTitle().getTitle();
        this.hireDate = e.getHireDate();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
