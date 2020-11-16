package com.sgte.sce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgte.sce.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
	Endereco findById(long id);
	Endereco deleteById(long id);

}
