package com.example.app.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.app.model.Estate;

@Repository
public interface EstateRepository extends JpaRepository<Estate, Long>{
	 Page<Estate> findAll(Pageable page);
	
}
