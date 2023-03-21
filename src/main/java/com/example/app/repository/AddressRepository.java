package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
