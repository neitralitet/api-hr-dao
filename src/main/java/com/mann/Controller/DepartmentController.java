package com.mann.Controller;

import com.mann.exception.ResourceNotFoundException;
import com.mann.model.Department;
import com.mann.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vladimir Mann
 */

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartment() {

        return departmentService.getAllDepartment();
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") Integer departmentId) throws ResourceNotFoundException {

        return ResponseEntity.ok().body( departmentService.getDepartmentById(departmentId));
    }

    @PostMapping("/department")
    public Department createDepartment(@RequestBody Department department) {

        return departmentService.createDepartment(department);
    }

    @PutMapping("/department/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable(value = "id") Integer departmentId,
                                                       @Valid @RequestBody Department departmentDetails) throws ResourceNotFoundException {

        return ResponseEntity.ok( departmentService.updateDepartment(departmentId,departmentDetails));
    }

    @DeleteMapping("/department/{id}")
    public Map<String, Boolean> deleteDepartment(@PathVariable(value = "id") Integer departmentId) throws ResourceNotFoundException {
        departmentService.deleteDepartment(departmentId);
        Map<String, Boolean> respons = new HashMap<>();
        respons.put("deleted", Boolean.TRUE);

        return respons;
    }

}
