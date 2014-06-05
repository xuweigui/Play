package com.windrift.model.dto;

import java.util.List;

/**
 * Created by gary on 5/06/14.
 */
public class EmployeeResultDTO {
    private EmployeeSearchCondition filter;
    private List<EmployeeForList> employees;

    public EmployeeResultDTO(EmployeeSearchCondition filter, List<EmployeeForList> employees) {
        this.filter = filter;
        this.employees = employees;
    }

    public EmployeeSearchCondition getFilter() {
        return filter;
    }

    public void setFilter(EmployeeSearchCondition filter) {
        this.filter = filter;
    }

    public List<EmployeeForList> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeForList> employees) {
        this.employees = employees;
    }
}
