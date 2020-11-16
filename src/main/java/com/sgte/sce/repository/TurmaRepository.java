package com.sgte.sce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgte.sce.models.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
	
	Turma findById(long id);
	Turma deleteById(long id);
	
	@Query("FROM Turma WHERE fk_subunidade = ?1")
	List<Turma> findAllBySu(long id);

}
