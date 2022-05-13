package com.sparta.northwind.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sparta.nothwind.entities.Shipper;
import com.sparta.northwind.repositories.ShipperRepository;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional


@SprintBootTest
@Transactional
public class ShipperControllerTest {

    @Autowired
    ShipperRepository shipperRepository;

    @Test
    public void testRepositoryLoaded() {
        Assertions.assertNotNull(shipperRepository);
    }

    @Test
    public void testCreateShipper()    {
        Shipper shipper = new Shipper();
        shipper.setId(247);
        shipper.setCompanyName("Shipping Company");
        shipper.setAddress("24 London Avenue");
        shipper.setCity("London");
        shipper.setRegion("Greater London");
        shipper.setPostalCode("NW7G24");
        shipper.setCountry("England");
        shipper.setPhone("02098765411");

        shipperRepository.save(shipper);

        Shipper result = shipperRepository.findById(247).get();
        Assertions.assertEquals("Shipping Company", shipper.getCompanyName());

    }

    @Test
    public void testUpdateShipper() {
        Shipper shipper = new Shipper();
        shipper.setId(247);
        shipper.setCompanyName("Shipping Co.");
        shipper.setAddress("24 London Avenue");
        shipper.setCity("London");
        shipper.setRegion("Greater London");
        shipper.setPostalCode("NW7G24");
        shipper.setCountry("England");
        shipper.setPhone("02098765411");

        shipperRepository.save(shipper);

        Shipper result = shipperRepository.findById(247).get();
        Assertions.assertEquals("Shipping Co.", shipper.getCompanyName());

    }

    @Test
    public void testDeleteShipper() {
        Shipper shipper = new Shipper();
        shipper.setId(247);
        shipper.setCompanyName("Shipping Co.");
        shipper.setAddress("24 London Avenue");
        shipper.setCity("London");
        shipper.setRegion("Greater London");
        shipper.setPostalCode("NW7G24");
        shipper.setCountry("England");
        shipper.setPhone("02098765411");

        shipperRepository.save(shipper);

        shipperRepository.deleteById(247);

        Boolean result = shipperRepository.findById(247).isEmpty();
        Assertions.assertTrue(result);

    }

}
