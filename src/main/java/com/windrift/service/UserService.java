package com.windrift.service;

import com.windrift.model.dto.EmployeeSearchCondition;
import com.windrift.model.entity.Employees;

import java.util.List;

public interface UserService {

    Employees getEmployee(String empNo);
    Long getTotalBy(EmployeeSearchCondition filter);
    List<Employees> getEmployeesBy(EmployeeSearchCondition filter);
}
