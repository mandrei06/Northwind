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
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ShipperRepository shipperRepository;


    // shipper crud
    @GetMapping("/allShippers")
    public List<Shipper> getAllShippers(){
        return shipperRepository.findAll();
    }

    @PostMapping(value = "addShipper")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addShipper(@RequestBody Shipper params) {
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

    @PutMapping(value = "modifyShipper")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void modifyShipper(@RequestBody Shipper params) {
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

    @DeleteMapping(value = "removeShipper")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void removeShipper(@RequestParam String param){
        shipperRepository.deleteById(param);
    }

    @GetMapping("/getShipper")
    public Object getShipper(@RequestParam String param){
        return shipperRepository.findById(param);
    }

    @GetMapping("/getShipperByRegion")
    public ResponseEntity<String> getShipperByRegion(@RequestParam String param) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            Optional<Shipper> result = shipperRepository.findById(param);
            return new ResponseEntity<String>(
                    mapper.writeValueAsString(result.get()),
                    headers, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>(
                "shipper not found",
                headers, HttpStatus.OK);
    }

    @GetMapping("/getShipperById")
    public ResponseEntity<String> getShipperById(@RequestParam Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            Optional<Shipper> result = shipperRepository.findById(id);
            return new ResponseEntity<String>(
                    mapper.writeValueAsString(result.get()),
                    headers, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>(
                "shipper not found",
                headers, HttpStatus.OK);
    }
}


   // @GetMapping("/getShipperOrders")
   // public void getShipperOrders(@RequestParam )