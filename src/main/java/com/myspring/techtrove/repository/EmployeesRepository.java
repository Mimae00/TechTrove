package com.myspring.techtrove.repository;

import com.myspring.techtrove.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
}
