package com.windrift.service;

import com.windrift.model.dto.EmployeeSearchCondition;
import com.windrift.model.entity.Employees;

import java.util.List;

public interface UserService {

    Employees getEmployee(String empNo);

    Employees getEmployeeByName(String firstName, String lastName);
    Long getTotalBy(EmployeeSearchCondition filter);
    List<Employees> getEmployeesBy(EmployeeSearchCondition filter);
}
