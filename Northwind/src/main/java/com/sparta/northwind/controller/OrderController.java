package com.sparta.northwind.controller;

import com.sparta.northwind.entities.Employee;
import com.sparta.northwind.entities.Order;
import com.sparta.northwind.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/allOrders")
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/getOrder")
    public Object getOrder(@RequestParam String param){
        return orderRepository.findById(Integer.valueOf(param));
    }

    @PostMapping("/addOrder")
    Order addOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }





    @DeleteMapping(value = "/deleteOrder")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteOrder(@RequestParam Integer param){
        orderRepository.deleteById(param);
    }

}
