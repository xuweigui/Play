package com.windrift.service;

import com.windrift.model.Employees;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
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
        return (Employees) em.createQuery("from Employees e " +
                "left join fetch e.employeeDepartments " +
                "left join fetch e.managerDepartments " +
                "left join fetch e.titles " +
                "left join fetch e.salaries " +
                "where e.empNo=:empNo")
                .setParameter("empNo", empNo).getSingleResult();
    }

    @Override
    public List<Employees> getEmployeesByDept(String deptNo) {
        return em.createQuery("from Employees                                                                                                                                                                                                                e " +
                "join fetch e.titles " +
                "join fetch e.employeeDepartments d " +
                "where d.deptNo=:deptNo")
                .setParameter("deptNo", deptNo)
                .getResultList();
    }
}
