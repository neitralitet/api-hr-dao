package com.mann.dao;

import com.mann.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Vladimir Mann
 */
public interface DepartmentDao extends JpaRepository<Department, Integer> {



}
