package com.windrift.model.entity;


import javax.persistence.*;

@Entity
@Table(name="departments")
public class Departments {

    @Id
    @Column(name = "dept_no")
    private String deptNo;

    @Column(name="dept_name")
    private String deptName;

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
