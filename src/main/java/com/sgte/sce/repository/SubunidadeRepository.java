package com.sgte.sce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgte.sce.models.Subunidade;

public interface SubunidadeRepository extends JpaRepository<Subunidade, Long>{
	
	Subunidade findById(long id);
	Subunidade deleteById(long id);
	
	@Query( value = "SELECT * FROM tb_subunidade WHERE fk_om = ?1", 
			nativeQuery = true)
	List<Subunidade> listarPorOm(long id);
	
	@Query( value = "SELECT fk_om FROM tb_subunidade WHERE id = ?1", 
			nativeQuery = true)
	long getFkOm(long id);

}
