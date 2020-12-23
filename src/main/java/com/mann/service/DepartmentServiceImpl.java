package com.mann.service;

import com.mann.dao.DepartmentDao;
import com.mann.exception.ResourceNotFoundException;
import com.mann.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vladimir Mann
 */

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> getAllDepartment() {
        return this.departmentDao.findAll();
    }

    @Override
    public Department getDepartmentById(Integer departmentId) throws ResourceNotFoundException {
        Department department = departmentDao.findById(departmentId).
                orElseThrow(() -> new ResourceNotFoundException("Department not found for this id::" + departmentId));

        return department;
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentDao.save(department);
    }

    @Override
    public Department updateDepartment(Integer departmentId, Department departmentDetails) throws ResourceNotFoundException {
        Department department = departmentDao.findById(departmentId).
                orElseThrow(() -> new ResourceNotFoundException("Department not found for this id::" + departmentId));

        department.setId(departmentDetails.getId());
        department.setDepartmentName(departmentDetails.getDepartmentName());

        final Department updatedDepartment = departmentDao.save(department);
        return updatedDepartment;
    }

    @Override
    public Boolean deleteDepartment(Integer departmentId) throws ResourceNotFoundException {
        Department department= departmentDao.findById(departmentId).
                orElseThrow(() -> new ResourceNotFoundException("Department not found for this id::" + departmentId));
        departmentDao.delete(department);
        return Boolean.TRUE;
    }
}
