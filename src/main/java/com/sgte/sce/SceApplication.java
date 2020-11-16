package com.sgte.sce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sgte.sce.security.entities.Usuario;
import com.sgte.sce.security.enums.PerfilEnum;
import com.sgte.sce.security.repositories.UsuarioRepository;
import com.sgte.utils.SenhaUtils;

@SpringBootApplication
public class SceApplication {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return args -> {
//			
//			Usuario usuario = new Usuario(null, "André de souza", "1500647", "CB_MESQUITA", SenhaUtils.gerarBCrypt("123456"), PerfilEnum.ROLE_ADMIN);
//			this.usuarioRepository.save(usuario);
//			
//		};
//	}

}
