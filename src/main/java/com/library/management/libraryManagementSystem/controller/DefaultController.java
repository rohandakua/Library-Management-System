package com.library.management.libraryManagementSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    @GetMapping("/api/v1/homepage")
    public ResponseEntity<String> getHomepage(){
        return new ResponseEntity<>("This is home page", HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<String> getPage(){
        return new ResponseEntity<>("every thing is ok", HttpStatus.OK);
    }
}
