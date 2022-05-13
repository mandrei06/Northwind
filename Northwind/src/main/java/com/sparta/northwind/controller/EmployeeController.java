package com.sparta.northwind.controller;

import com.sparta.northwind.entities.Employee;
import com.sparta.northwind.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/northwind")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
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

    @PutMapping("/edit")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    Employee updateEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/remove")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void removeEmployee(@RequestParam Integer id){
        employeeRepository.deleteById(id);
    }

}
