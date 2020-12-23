package com.mann.Controller;

import com.mann.exception.ResourceNotFoundException;
import com.mann.model.Employee;
import com.mann.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {

        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Integer employeeId) throws ResourceNotFoundException {


        return ResponseEntity.ok().body(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping("/employee")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {

        return employeeService.createEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {

        return ResponseEntity.ok(employeeService.updateEmployee(employeeId,employeeDetails));
    }


    @DeleteMapping("/employee/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId) throws ResourceNotFoundException {
        employeeService.deleteEmployee(employeeId);
        Map<String, Boolean> respons = new HashMap<>();
        respons.put("deleted", Boolean.TRUE);
        return respons;
    }
}
