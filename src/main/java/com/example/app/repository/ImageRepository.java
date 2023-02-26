package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.app.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
	
	@Query("SELECT i from Image i where estate_Id in :ids")
	List<Image> findImagesByEstateIds(@Param("ids") List<Long> estateIds);
}
