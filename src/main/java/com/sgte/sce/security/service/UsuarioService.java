package com.sgte.sce.security.service;

import java.util.Optional;

import com.sgte.sce.models.Om;
import com.sgte.sce.security.entities.Usuario;

public interface UsuarioService {
	Optional<Usuario> buscarPorUserName(String userName);
	Optional<Om> getUserOm(Long id);
}
