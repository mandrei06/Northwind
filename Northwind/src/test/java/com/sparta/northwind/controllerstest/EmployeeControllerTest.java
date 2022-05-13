package com.sparta.northwind.controllerstest;
import com.sparta.northwind.entities.Customer;
import com.sparta.northwind.entities.Employee;
import com.sparta.northwind.repositories.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class EmployeeControllerTest {

    @Autowired
    private EmployeeRepository employeeRepository;


    // Employee By ID
    @Test
    public void checkEmployeeIsFound() {
        Employee employee = new Employee();
        employeeRepository.save(employee);
        Employee result = employeeRepository.findById(14).get();
        Assertions.assertEquals("Jean", result.getLastName());
    }

    // Add New Employee
    @Test
    public void checkAddEmployee() {
        Employee employee = new Employee();
        Employee savedEmployee = employeeRepository.save(employee);
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    // Edit Existing Employee
    @Test
    public  void checkEmployeeIsEdited() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("Updated Davolio");
        employeeRepository.save(employee);
        Employee employeeUpdated = employeeRepository.findById(1).get();
        Assertions.assertEquals("Updated Davolio", employeeUpdated.getLastName());

    }

    // Remove Existing Employee
    @Test
    public void checkEmployeeIsRemoved() {
        employeeRepository.deleteById(10);
        boolean result = employeeRepository.findById(10).isEmpty();
        Assertions.assertTrue(result);
    }

}
