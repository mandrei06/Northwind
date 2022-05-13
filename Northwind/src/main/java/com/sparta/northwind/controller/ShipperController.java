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
    public void createShipper(@RequestBody Shipper shipInfo) {
        Shipper shipper = new Shipper();
        shipper.setId(shipInfo.getId());
        shipper.setCompanyName(shipInfo.getCompanyName());
        shipper.setAddress(shipInfo.getAddress());
        shipper.setCity(shipInfo.getCity());
        shipper.setRegion(shipInfo.getRegion());
        shipper.setPostalCode(shipInfo.getPostalCode());
        shipper.setCountry(shipInfo.getCountry());
        shipper.setPhone(shipInfo.getPhone());

        shipperRepository.save(shipper);
    }

    @PutMapping(value = "updateShipper")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateShipper(@RequestBody Shipper shipInfo) {
        Shipper shipper = new Shipper();
        shipper.setId(shipInfo.getId());
        shipper.setCompanyName(shipInfo.getCompanyName());
        shipper.setAddress(shipInfo.getAddress());
        shipper.setCity(shipInfo.getCity());
        shipper.setRegion(shipInfo.getRegion());
        shipper.setPostalCode(shipInfo.getPostalCode());
        shipper.setCountry(shipInfo.getCountry());
        shipper.setPhone(shipInfo.getPhone());

        shipperRepository.save(shipper);
    }

    @DeleteMapping(value = "deleteShipper")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteShipper(@RequestParam Integer id){
        shipperRepository.deleteById(id);
    }

    @GetMapping("/getShipper")
    public Object getShipper(@RequestParam Integer id){
        return shipperRepository.findById(id);
    }

}
