package com.sgte.sce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgte.sce.models.Om;

public interface OmRepository extends JpaRepository<Om, Long>{
	
	Om findById(long id);
	Om deleteById(long id);

}
