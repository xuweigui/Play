package com.windrift.service;

import com.windrift.model.dto.EmployeeSearchCondition;
import com.windrift.model.entity.Employees;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.*;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public Employees getEmployee(String empNo) {
        try {
            return (Employees) em.createQuery("from Employees e " +
                    "left join fetch e.employeeDepartments " +
                    "left join fetch e.managerDepartments " +
                    "left join fetch e.titles " +
                    "left join fetch e.salaries " +
                    "where e.empNo=:empNo")
                    .setParameter("empNo", empNo).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Employees getEmployeeByName(String firstName, String lastName) {
        try {
            return (Employees) em.createQuery("from Employees e " +
                    "left join fetch e.employeeDepartments " +
                    "left join fetch e.managerDepartments " +
                    "where e.firstName=:fn and e.lastName=:ln")
                    .setParameter("fn", firstName)
                    .setParameter("ln", lastName)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Long getTotalBy(EmployeeSearchCondition filter) {

        Map<String, Object> params = new HashMap<>();

        Query query = em.createQuery(getQuery(filter, true, params));

        setParameters(params, query);

        return (Long) query.getSingleResult();
    }

    @Override
    public List<Employees> getEmployeesBy(EmployeeSearchCondition filter) {

        Map<String, Object> params = new HashMap<>();

        Query query = em.createQuery(getQuery(filter, false, params));

        setParameters(params, query);

        return query.setMaxResults(filter.getCountPerPage())
                .setFirstResult((filter.getCurrentPage() - 1) * filter.getCountPerPage())
                .getResultList();
    }

    private void setParameters(Map<String, Object> params, Query query) {
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() instanceof Date) {
                query.setParameter(entry.getKey(), (Date) entry.getValue(), TemporalType.DATE);
            } else {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
    }

    private String getQuery(EmployeeSearchCondition filter, boolean forCount, Map<String, Object> params) {

        StringBuilder hql = new StringBuilder();
        if (forCount)
            hql.append("select count(*) ");
        hql.append("from Employees e ");
        if (forCount) {
            hql.append("join e.titles t ")
            .append("join e.employeeDepartments d ");
        }
        else {
            hql.append("join fetch e.titles t ")
                .append("join fetch e.employeeDepartments d ");
        }
        hql.append("where d.deptNo=:deptNo");
        params.put("deptNo", filter.getDeptNo());

        if (StringUtils.isNotEmpty(filter.getFirstName())) {
            hql.append(" and upper(e.firstName) like :firstName");
            params.put("firstName", "%" + filter.getFirstName().toUpperCase() + "%");
        }

        if (StringUtils.isNotEmpty(filter.getLastName())) {
            hql.append(" and upper(e.lastName) like :lastName");
            params.put("lastName", "%" + filter.getLastName().toUpperCase() + "%");
        }

        if (StringUtils.isNotEmpty(filter.getTitle())) {
            hql.append(" and upper(t.title) like :title");
            params.put("title", "%" + filter.getTitle().toUpperCase() + "%");
        }

        if (filter.isGenderProvided()) {
            hql.append( " and e.gender=:gender");
            params.put("gender", filter.getGender());
        }

        if (filter.getHireDateFrom() != null) {
            hql.append(" and e.hireDate>=:hireDateFrom");
            params.put("hireDateFrom", filter.getHireDateFrom());
        }

        if (filter.getHireDateTo() != null) {
            hql.append(" and e.hireDate<=:hireDateTo");
            params.put("hireDateTo", filter.getHireDateTo());
        }

        return hql.toString();
    }

}
