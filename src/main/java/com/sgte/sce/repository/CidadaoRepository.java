package com.sgte.sce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgte.response.CidadaoComEndereco;
import com.sgte.sce.models.Cidadao;

public interface CidadaoRepository extends JpaRepository<Cidadao, Long>{
	
	Cidadao findById(long id);
	Cidadao deleteById(long id);
	
	@Query("FROM Cidadao WHERE fk_turma = ?1")
	List<Cidadao> findByTurma(long id);
	
	@Query( value = "SELECT c.id, c.cidadaos_status, c.comportamento, " + 
			"c.cpf, c.data_de_nascimento, c.data_de_praca, c.email, c.estado_civil, c.genero, c.nome_completo, " + 
			"c.nome_de_guerra, c.nome_mae, c.nome_pai, c.post_grad, c.qm, c.ra, c.rg, c.telefone, c.tipo, " + 
			"e.bairro, e.cidade, e.estado, e.rua, c.numero_recruta, e.id as eid " + 
			"FROM tb_cidadao c " + 
			"LEFT JOIN tb_endereco e ON c.id = e.cidadao_id " + 
			"where c.id = ?", 
	nativeQuery = true)
	List<?> findCidadaoComEndereco(long id);

}
