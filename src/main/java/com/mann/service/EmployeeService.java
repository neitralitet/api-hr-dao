package com.mann.service;

import com.mann.exception.ResourceNotFoundException;
import com.mann.model.Department;
import com.mann.model.Employee;

import java.util.List;

/**
 * @author Vladimir Mann
 */
public interface EmployeeService {

    List<Employee> getAllEmployee();

    Employee getEmployeeById(Integer employeeId) throws ResourceNotFoundException;

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Integer employeeId, Employee employeeDetails) throws ResourceNotFoundException;

    Boolean deleteEmployee(Integer employeeId) throws ResourceNotFoundException;
}
