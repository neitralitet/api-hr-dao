package com.mann.service;


import com.mann.exception.ResourceNotFoundException;
import com.mann.model.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author Vladimir Mann
 */
public interface DepartmentService {
    List<Department> getAllDepartment();

    Department getDepartmentById(Integer departmentId) throws ResourceNotFoundException;

    Department createDepartment(Department department);

    Department updateDepartment(Integer departmentId, Department departmentDetails) throws ResourceNotFoundException;

    Boolean deleteDepartment(Integer departmentId) throws ResourceNotFoundException;

}
