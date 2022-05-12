package com.sparta.northwind.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwind.entities.Employee;
import com.sparta.northwind.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/findEmployeeById")
    public ResponseEntity<String> getEmployeeById(@RequestParam Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            Optional<Employee> result = employeeRepository.findById(id);
            return new ResponseEntity<String>(
                    mapper.writeValueAsString(result.get()),
                    headers, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>(
                "employee not found",
                headers, HttpStatus.OK);
    }


//    @PostMapping(value = "/addEmployee")
//    @ResponseStatus(code = HttpStatus.CREATED)
//    public void addEmployee(@RequestBody Employee params){
//        Employee employee = new Employee();
//        employee.setId(params.getId());
//        employee.setLastName(params.getLastName());
//        employee.setFirstName(params.getFirstName());
//        employee.setTitle(params.getTitle());
//        employee.setTitleOfCourtesy(params.getTitleOfCourtesy());
//        employee.setBirthDate(params.getBirthDate());
//        employee.setHireDate(params.getHireDate());
//        employee.setAddress(params.getAddress());
//        employee.setCity(params.getCity());
//        employee.setRegion(params.getRegion());
//        employee.setPostalCode(params.getPostalCode());
//        employee.setCountry(params.getCountry());
//        employee.setHomePhone(params.getHomePhone());
//        employee.setExtension(params.getExtension());
//        employee.setPhoto(params.getPhoto());
//        employee.setReportsTo(params.getReportsTo());
//        employee.setPhotoPath(params.getPhotoPath());
//        employee.setSalary(params.getSalary());
//
//        employeeRepository.save(employee);
//    }
}
