package com.example.app.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.app.model.Estate;

@Repository
public interface EstateRepository extends JpaRepository<Estate, Long>{
	
	@Override 
	@Query(value = "SELECT e from Estate e join fetch e.address a", 
		countQuery = "SELECT count(*) from Estate e join e.address a")
	 Page<Estate> findAll(Pageable page);
}
