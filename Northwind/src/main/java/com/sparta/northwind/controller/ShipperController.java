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
public class ShipperController {

    @Autowired
    private ShipperRepository shipperRepository;


    // shipper crud
    @GetMapping("/allShippers")
    public List<Shipper> getAllShippers(){
        return shipperRepository.findAll();
    }

    @PostMapping(value = "createShipper")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createShipper(@RequestBody Shipper params) {
        Shipper shipper = new Shipper();
        shipper.setId(params.getId());
        shipper.setCompanyName(params.getCompanyName());
        shipper.setAddress(params.getAddress());
        shipper.setCity(params.getCity());
        shipper.setRegion(params.getRegion());
        shipper.setPostalCode(params.getPostalCode());
        shipper.setCountry(params.getCountry());
        shipper.setPhone(params.getPhone());

        shipperRepository.save(shipper);
    }

    @PutMapping(value = "updateShipper")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateShipper(@RequestBody Shipper params) {
        Shipper shipper = new Shipper();
        shipper.setId(params.getId());
        shipper.setCompanyName(params.getCompanyName());
        shipper.setAddress(params.getAddress());
        shipper.setCity(params.getCity());
        shipper.setRegion(params.getRegion());
        shipper.setPostalCode(params.getPostalCode());
        shipper.setCountry(params.getCountry());
        shipper.setPhone(params.getPhone());

        shipperRepository.save(shipper);
    }

    @DeleteMapping(value = "deleteShipper")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteShipper(@RequestParam String param){
        shipperRepository.deleteById(param);
    }

    @GetMapping("/getShipper")
    public Object getShipper(@RequestParam String param){
        return shipperRepository.findById(param);
    }

}
