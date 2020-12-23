package com.mann.dao;

import com.mann.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vladimir Mann
 */
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
