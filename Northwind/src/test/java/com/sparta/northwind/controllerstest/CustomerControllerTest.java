package com.sparta.northwind.controllerstest;

import com.sparta.northwind.entities.Customer;
import com.sparta.northwind.repositories.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
public class CustomerControllerTest {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void checkRepoLoaded(){
        Assertions.assertNotNull(customerRepository);
    }

    @Test
    public void checkCustomerIsFound(){
        Customer customer= customerRepository.findById("ANDYM").get();
        Assertions.assertEquals("Andrei Marincas",customer.getContactName());
    }
    @Test
    public void checkCustomerIsInserted(){
        Customer customer=new Customer();
        customer.setId("ANDYY");
        customer.setCompanyName("Sparta");
        customer.setContactName("Andrei Marincas");
        customer.setContactTitle("Sales Representative");
        customer.setAddress("Obere Str. 57");
        customer.setCity("Berlin");
        customer.setRegion(null);
        customer.setPostalCode("12209");
        customer.setCountry("Germany");
        customer.setPhone("030-0074321");
        customer.setFax("030-0076545");
        customerRepository.save(customer);
        Customer result= customerRepository.findById("ANDYY").get();
        Assertions.assertEquals("Andrei Marincas",result.getContactName());
    }
    @Test
    public void checkCustomerIsUpdated(){
        Customer customer=new Customer();
        customer.setId("ANDYY");
        customer.setCompanyName("Sparta");
        customer.setContactName("Andy Marincas");
        customer.setContactTitle("Sales Representative");
        customer.setAddress("Obere Str. 57");
        customer.setCity("Berlin");
        customer.setRegion(null);
        customer.setPostalCode("12209");
        customer.setCountry("Germany");
        customer.setPhone("030-0074321");
        customer.setFax("030-0076545");
        customerRepository.save(customer);
        Customer result= customerRepository.findById("ANDYY").get();
        Assertions.assertEquals("Andy Marincas",result.getContactName());
    }
    @Test
    public void checkCustomerIsDeleted(){
        Customer customer=new Customer();
        customer.setId("ANDYY");
        customer.setCompanyName("Sparta");
        customer.setContactName("Andrei Marincas");
        customer.setContactTitle("Sales Representative");
        customer.setAddress("Obere Str. 57");
        customer.setCity("Berlin");
        customer.setRegion(null);
        customer.setPostalCode("12209");
        customer.setCountry("Germany");
        customer.setPhone("030-0074321");
        customer.setFax("030-0076545");
        customerRepository.save(customer);
        customerRepository.deleteById("ANDYY");
        boolean result = customerRepository.findById("ANDYY").isEmpty();

        Assertions.assertTrue(result);
    }

}
