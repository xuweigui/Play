package com.windrift.model.entity;


import com.windrift.common.util.DateUtil;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="employees")
public class Employees {

    @Id
    @Column(name = "emp_no")
    private String empNo;

    @Temporal(TemporalType.DATE)
    @Column(name="birth_date")
    private Date birthDate;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="gender")
    private Character gender;

    @Temporal(TemporalType.DATE)
    @Column(name="hire_date")
    private Date hireDate;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="dept_emp",
            joinColumns=@JoinColumn(name="emp_no"),
            inverseJoinColumns=@JoinColumn(name="dept_no"))
    @WhereJoinTable(clause="to_date > now()")
    Set<Departments> employeeDepartments = new HashSet<>();

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="dept_manager",
            joinColumns=@JoinColumn(name="emp_no"),
            inverseJoinColumns=@JoinColumn(name="dept_no"))
    @WhereJoinTable(clause="to_date > now()")
    Set<Departments> managerDepartments = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no")
    @Where(clause = "to_date > now()")
    Set<Salaries> salaries = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no")
    @Where(clause = "to_date > now()")
    Set<Titles> titles = new HashSet<>();


    public boolean isManager()
    {
        return !(managerDepartments != null && managerDepartments.isEmpty());
    }

    public Departments getCurrentDepartment()
    {
        if (employeeDepartments != null && !employeeDepartments.isEmpty())
            return employeeDepartments.iterator().next();
        else
            return null;
    }

    public Salaries getCurrentSalary()
    {
        if (salaries != null && !salaries.isEmpty())
            return salaries.iterator().next();
        else
            return null;
    }

    public Titles getCurrentTitle()
    {
        if (titles != null && ! titles.isEmpty())
            return titles.iterator().next();
        else
            return null;
    }

    public String getAge()
    {
        return DateUtil.getDurationInYearToNow(birthDate);
    }

    public String getYearsWithCompany()
    {
        return DateUtil.getDurationInYearToNow(hireDate);
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Set<Departments> getEmployeeDepartments() {
        return employeeDepartments;
    }

    public void setEmployeeDepartments(Set<Departments> employeeDepartments) {
        this.employeeDepartments = employeeDepartments;
    }

    public Set<Departments> getManagerDepartments() {
        return managerDepartments;
    }

    public void setManagerDepartments(Set<Departments> managerDepartments) {
        this.managerDepartments = managerDepartments;
    }

    public Set<Salaries> getSalaries() {
        return salaries;
    }

    public void setSalaries(Set<Salaries> salaries) {
        this.salaries = salaries;
    }

    public Set<Titles> getTitles() {
        return titles;
    }

    public void setTitles(Set<Titles> titles) {
        this.titles = titles;
    }
}
