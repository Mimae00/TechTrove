package com.myspring.techtrove.controller;


import com.myspring.techtrove.models.Employees;
import com.myspring.techtrove.repository.EmployeesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeesController {

    private static final String TECH_TROVE = "Tech-Trove";

    @Autowired
    private EmployeesRepository employeesRepository;

    HttpHeaders responseHeaders = new HttpHeaders();

    @GetMapping
    public ResponseEntity<List<Employees>> list() {
        responseHeaders.add(TECH_TROVE, "Get All Employees");
        return new ResponseEntity<>(employeesRepository.findAll(),responseHeaders, 200) ;
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Employees> get(@PathVariable Long id) {
        responseHeaders.add(TECH_TROVE, "Get 1 Employee");
        return new ResponseEntity<>(employeesRepository.getReferenceById(id),responseHeaders,200);
    }

    @PostMapping
    public ResponseEntity<Employees> create(@RequestBody final Employees employees){
        responseHeaders.add(TECH_TROVE, "Get 1 Employee");
        return new ResponseEntity<>(employeesRepository.saveAndFlush(employees), responseHeaders, 201);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void  delete(@PathVariable Long id) {
        employeesRepository.deleteById(id);
    }


    @PutMapping("{id}")
    public ResponseEntity<Employees> update(@PathVariable Long id, @RequestBody Employees employees) {
        responseHeaders.add(TECH_TROVE, "Delete Employee");
        Employees existingEmployees = employeesRepository.getReferenceById(id);
        BeanUtils.copyProperties(employees, existingEmployees, "employee_id");
        return new ResponseEntity<>(employeesRepository.saveAndFlush(existingEmployees), responseHeaders, 200);
    }


}
