package com.myspring.techtrove.controller;

import com.myspring.techtrove.models.Managers;
import com.myspring.techtrove.repository.ManagersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/managers")
public class ManagersController {

    private static final String TECH_TROVE = "Tech-Trove";
    @Autowired
    private ManagersRepository managersRepository;

    HttpHeaders responseHeaders = new HttpHeaders();

    @GetMapping
    public ResponseEntity<List<Managers>> list() {
        responseHeaders.add(TECH_TROVE, "Get All Managers");
        return new ResponseEntity<>(managersRepository.findAll(), responseHeaders, 200) ;
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Managers> get(@PathVariable Long id) {
        responseHeaders.add(TECH_TROVE, "Get All Managers");
        return new ResponseEntity<>(managersRepository.getReferenceById(id), responseHeaders, 200);
    }

    @PostMapping
    public ResponseEntity<Managers> create(@RequestBody final Managers session){
        responseHeaders.add(TECH_TROVE, "Create Manager");
        return new ResponseEntity<>(managersRepository.saveAndFlush(session), responseHeaders, 201);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        managersRepository.deleteById(id);
    }


    @PutMapping("{id}")
    public ResponseEntity<Managers> update(@PathVariable Long id, @RequestBody Managers session) {
        responseHeaders.add(TECH_TROVE, "Create Manager");
        Managers existingSession = managersRepository.getReferenceById(id);
        BeanUtils.copyProperties(session, existingSession, "manager_id");
        return new ResponseEntity<>(managersRepository.saveAndFlush(existingSession), responseHeaders, 200);
    }



}
