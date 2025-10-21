package com.health.controller;

import com.health.model.Laboratory;
import com.health.service.ILaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laboratories")
@CrossOrigin(origins = "*")
public class LaboratoryController {

    @Autowired
    private ILaboratoryService service;

    @GetMapping
    public ResponseEntity<List<Laboratory>> findAll() throws Exception {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratory> findById(@PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Laboratory> save(@RequestBody Laboratory laboratory) throws Exception {
        return new ResponseEntity<>(service.save(laboratory), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laboratory> update(@PathVariable("id") Integer id, @RequestBody Laboratory laboratory) throws Exception {
        return new ResponseEntity<>(service.update(laboratory, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
