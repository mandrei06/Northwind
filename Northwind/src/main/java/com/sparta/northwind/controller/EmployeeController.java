package com.sparta.northwind.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwind.entities.Customer;
import com.sparta.northwind.entities.Employee;
import com.sparta.northwind.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    @GetMapping("/employee")
    public Object getEmployee(@RequestParam Integer id){
        return employeeRepository.findById(id);
    }

    @PostMapping("/add")
    Employee getEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/editEmployee")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    Employee updateEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/removeEmployee")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void removeEmployee(@RequestParam Integer id){
        employeeRepository.deleteById(id);
    }

}
