package com.sparta.northwind.controller;

import com.sparta.northwind.entities.Customer;
import com.sparta.northwind.entities.Employee;
import com.sparta.northwind.entities.Order;
import com.sparta.northwind.entities.Shipper;
import com.sparta.northwind.repositories.CustomerRepository;
import com.sparta.northwind.repositories.EmployeeRepository;
import com.sparta.northwind.repositories.OrderRepository;
import com.sparta.northwind.repositories.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ShipperRepository shipperRepository;


    //***********************************************************************************************************
    //CUSTOMERS CRUD
    //***********************************************************************************************************
    @GetMapping("/allCustomers")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    @GetMapping("/getCustomer")
    public Object getCustomer(@RequestParam String param){
        return customerRepository.findById(param);
    }

    @PostMapping(value = "addCustomer")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer params) {
        Customer customer=new Customer();
        customer.setId(params.getId());
        customer.setCompanyName(params.getCompanyName());
        customer.setContactName(params.getContactName());
        customer.setContactTitle(params.getContactTitle());
        customer.setAddress(params.getAddress());
        customer.setCity(params.getCity());
        customer.setRegion(params.getRegion());
        customer.setPostalCode(params.getPostalCode());
        customer.setCountry(params.getCountry());
        customer.setPhone(params.getPhone());
        customer.setFax(params.getFax());

        customerRepository.save(customer);
    }

    @PutMapping(value = "modifyCustomer")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void modifyCustomer(@RequestBody Customer params) {
        Customer customer=new Customer();
        customer.setId(params.getId());
        customer.setCompanyName(params.getCompanyName());
        customer.setContactName(params.getContactName());
        customer.setContactTitle(params.getContactTitle());
        customer.setAddress(params.getAddress());
        customer.setCity(params.getCity());
        customer.setRegion(params.getRegion());
        customer.setPostalCode(params.getPostalCode());
        customer.setCountry(params.getCountry());
        customer.setPhone(params.getPhone());
        customer.setFax(params.getFax());

        customerRepository.save(customer);
    }

    @DeleteMapping(value = "deleteCustomer")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteCustomer(@RequestParam String param){
        customerRepository.deleteById(param);
    }



    //******************************************************************************************************************
    //ORDERS CRUD
    //******************************************************************************************************************

//    @GetMapping("/allOrders")
//    public List<Order> getAllOrders(){
//        return orderRepository.findAll();
//    }

    //******************************************************************************************************************
    //SHIPPERS CRUD
    //******************************************************************************************************************

    @GetMapping("/allShippers")
    public List<Shipper> getAllShippers(){
        return shipperRepository.findAll();
    }




}
