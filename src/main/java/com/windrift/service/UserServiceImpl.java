package com.windrift.service;

import com.windrift.model.dto.EmployeeSearchCondition;
import com.windrift.model.entity.Employees;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    public Long getTotalBy(EmployeeSearchCondition filter) {
        StringBuilder hql = new StringBuilder();
        hql.append("from Employees e ")
                .append("join e.titles ")
                .append("join e.employeeDepartments d ")
                .append("where d.deptNo=:deptNo");

       return (Long) em.createQuery("select count(*) " + hql.toString())
                .setParameter("deptNo", filter.getDeptNo()).getSingleResult();
    }

    @Override
    public List<Employees> getEmployeesBy(EmployeeSearchCondition filter) {
        
        StringBuilder hql = new StringBuilder();
        hql.append("from Employees e ")
            .append("join fetch e.titles ")
            .append("join fetch e.employeeDepartments d ")
            .append("where d.deptNo=:deptNo");

        return em.createQuery(hql.toString())
                .setParameter("deptNo", filter.getDeptNo())
                .setMaxResults(filter.getCountPerPage())
                .setFirstResult((filter.getCurrentPage() - 1) * filter.getCountPerPage())
                .getResultList();
    }
}
