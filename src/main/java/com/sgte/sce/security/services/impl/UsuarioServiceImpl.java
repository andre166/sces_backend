package com.sgte.sce.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgte.sce.models.Om;
import com.sgte.sce.repository.OmRepository;
import com.sgte.sce.security.entities.Usuario;
import com.sgte.sce.security.repositories.UsuarioRepository;
import com.sgte.sce.security.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private OmRepository omRepository;
	
	public Optional<Usuario> buscarPorUserName(String userName) {
		return Optional.ofNullable(this.usuarioRepository.findByUserName(userName));
	}

	@Override
	public Optional<Om> getUserOm(Long id) {
		return omRepository.findById(id);
	}

}
