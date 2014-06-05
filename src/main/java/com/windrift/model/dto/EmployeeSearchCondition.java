package com.windrift.model.dto;

import java.util.Date;

/**
 * Created by gary on 5/06/14.
 */
public class EmployeeSearchCondition {

    private static final Character MALE = 'M';
    private static final Character FEMALE = 'F';
    private String deptNo;
    private String firstName;
    private String lastName;
    private Character gender;
    private String title;
    private Date hireDateFrom;
    private Date hireDateTo;


    private int currentPage = 1;
    private int countPerPage = 30;
    private Long total;

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
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

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCountPerPage() {
        return countPerPage;
    }

    public void setCountPerPage(int countPerPage) {
        this.countPerPage = countPerPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isGenderProvided()
    {
        return MALE.equals(this.gender) || FEMALE.equals(this.gender);
    }

    public Date getHireDateFrom() {
        return hireDateFrom;
    }

    public void setHireDateFrom(Date hireDateFrom) {
        this.hireDateFrom = hireDateFrom;
    }

    public Date getHireDateTo() {
        return hireDateTo;
    }

    public void setHireDateTo(Date hireDateTo) {
        this.hireDateTo = hireDateTo;
    }
}
