package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.app.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
	
	@Query("SELECT a from Address a where a.city like CONCAT('%',:searchText,'%') or a.street like CONCAT('%',:searchText,'%') or a.province like CONCAT('%',:searchText,'%')")
	public List<Address> searchLocation(@Param("searchText") String searchText);
}
