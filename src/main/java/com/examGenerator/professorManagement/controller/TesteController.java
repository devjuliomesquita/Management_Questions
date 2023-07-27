package com.examGenerator.professorManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teste")
public class TesteController {
    @PostMapping
    public ResponseEntity<?> testePost(){
        return new ResponseEntity<>("Post", HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> testeGet(){
        return new ResponseEntity<>("Get", HttpStatus.OK);
    }
}
