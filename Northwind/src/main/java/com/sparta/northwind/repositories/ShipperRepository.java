package com.sparta.northwind.repositories;

import com.sparta.northwind.entities.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<Shipper, Integer> {

}