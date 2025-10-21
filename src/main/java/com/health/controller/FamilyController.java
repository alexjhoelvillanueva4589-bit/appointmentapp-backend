package com.health.controller;

import com.health.model.Family;
import com.health.service.IFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/families")
@CrossOrigin(origins = "*")
public class FamilyController {

    @Autowired
    private IFamilyService service;

    @GetMapping
    public ResponseEntity<List<Family>> findAll() throws Exception {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Family> findById(@PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Family> save(@RequestBody Family family) throws Exception {
        return new ResponseEntity<>(service.save(family), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Family> update(@PathVariable("id") Integer id, @RequestBody Family family) throws Exception {
        return new ResponseEntity<>(service.update(family, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
