package com.windrift.service;

import com.windrift.model.Employees;

import java.util.List;

public interface UserService {

    Employees getEmployee(String empNo);
    List<Employees> getEmployeesByDept(String deptNo);
}
