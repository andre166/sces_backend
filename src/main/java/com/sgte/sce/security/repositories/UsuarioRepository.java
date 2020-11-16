package com.sgte.sce.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sgte.sce.security.entities.Usuario;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByUserName(String userName);
	Usuario findById(long id);
	
	@Query( value = "UPDATE tb_usuario SET fk_subunidade = ?1 where id = ?2", 
			nativeQuery = true)
	Usuario insertSu(long idSu, long userId);
	
	@Query( value = "SELECT u.id, u.nome, u.cpf, u.perfil, u.user_name, "
			+ "s.id as idSU, s.nome_completo as nomeCompletoSu, s.nome_subunidade as nomeSu from tb_usuario u "
			+ "LEFT JOIN tb_subunidade s ON u.fk_subunidade = s.id where u.fk_om = ?1", 
	nativeQuery = true)
	List<?> listUsuariosComSubunidades(long idOm);
	
	
	@Query( value ="SELECT u.id, u.nome, u.cpf, u.perfil, u.user_name, "
			+ "s.id as idSU, s.nome_completo as nomeCompletoSu, s.nome_subunidade as nomeSu from tb_usuario u "
			+ "LEFT JOIN tb_subunidade s ON u.fk_subunidade = s.id where u.id = ?1",
	nativeQuery = true)
	List<?> listUsuarioUnicoComSubunidade(long id);
	
}
