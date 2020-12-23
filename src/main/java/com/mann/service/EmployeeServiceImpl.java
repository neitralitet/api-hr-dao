package com.mann.service;

import com.mann.dao.DepartmentDao;
import com.mann.dao.EmployeeDao;
import com.mann.exception.ResourceNotFoundException;
import com.mann.model.Department;
import com.mann.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vladimir Mann
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) throws ResourceNotFoundException {
        Employee employee = employeeDao.findById(employeeId).
                orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id::" + employeeId));

        return employee;
    }

    @Override
    public Employee createEmployee(Employee employee) {
       return  employeeDao.save(employee);
    }

    @Override
    public Employee updateEmployee(Integer employeeId, Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeDao.findById(employeeId).
                orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id::" + employeeId));

        employee.setId(employeeDetails.getId());
        employee.setName(employeeDetails.getName());
        employee.setSecondName(employeeDetails.getSecondName());
        employee.setPatronymicName(employeeDetails.getPatronymicName());
        employee.setDateOfBirth(employeeDetails.getDateOfBirth());
        employee.setDepartmentId(employeeDetails.getDepartmentId());
        employee.setSalary(employeeDetails.getSalary());
        final Employee updatedEmployee = employeeDao.save(employee);
        return updatedEmployee;
    }

    @Override
    public Boolean deleteEmployee(Integer employeeId) throws ResourceNotFoundException {
        Employee employee = employeeDao.findById(employeeId).
                orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id::" + employeeId));
        employeeDao.delete(employee);

        return Boolean.TRUE;
    }
}
