package com.sgte.sce.security.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgte.response.Response;
import com.sgte.response.ResponseInsertSu;
import com.sgte.response.UsuarioComSu;
import com.sgte.sce.models.Om;
import com.sgte.sce.models.Subunidade;
import com.sgte.sce.repository.OmRepository;
import com.sgte.sce.repository.SubunidadeRepository;
import com.sgte.sce.security.entities.Usuario;
import com.sgte.sce.security.repositories.UsuarioRepository;
import com.sgte.sce.security.service.UsuarioService;
import com.sgte.utils.SenhaUtils;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	UsuarioService usarioService;
	
	@Autowired
	OmRepository omRepository;
	@Autowired
	SubunidadeRepository subunidadeRepository;
	
	@PostMapping("/salvar")
	public Usuario salvaUsuario(@RequestBody Usuario usuario) {
		
		Usuario user = new Usuario();
		
		user.setNome(usuario.getNome());
		user.setUserName(usuario.getUserName());
		user.setCpf(usuario.getCpf());
		user.setSenha(SenhaUtils.gerarBCrypt(usuario.getSenha()));
		user.setPerfil(usuario.getPerfil());
		user.setOm(usuario.getOm());
		user.setSubunidade(usuario.getSubunidade());
		
		
		return usuarioRepository.save(user);
	}
	
	@PostMapping("/salvarComSu")
	public ResponseEntity<Usuario> salvaUsuarioComSu(@RequestBody ResponseInsertSu<?> resp) {
		
		Usuario user = new Usuario();
		user = resp.getUsuario();
		long suId = resp.getSu(); 
		
		Subunidade su = subunidadeRepository.findById(suId);
		user.setSubunidade(su);
		
		usuarioRepository.save(user);
		
		return ResponseEntity.ok(user);
	}
	
	
	@GetMapping("/getUserOm/{id}")
	public Optional<Om> listaUserOm(@PathVariable(value="id") long id){
		
		Usuario u = usuarioRepository.findById(id);
		Om om = u.getOm();
				
		return Optional.ofNullable(om);
	}
	
	@GetMapping("/listar")
	public List<Usuario> listaUsuario(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/listUsuarioUnicoComSubunidade/{id}")
	public  List<?> listUsuarioUnicoComSubunidade(@PathVariable(value="id") long id){
		
		List lista = usuarioRepository.listUsuarioUnicoComSubunidade(id);
		
		List l = lista;
        Iterator it =l.iterator();
        
        UsuarioComSu u = new UsuarioComSu();
        
        List<UsuarioComSu> listU = new ArrayList();
        
    	while(it.hasNext()){
        
            Object rows[] = (Object[])it.next();
            
            if(rows[0] != null ) {
            	u.setUserId(rows[0].toString());            	
            }
            
            if(rows[1] != null ) {
            	u.setNome(rows[1].toString());            	
            }
            
            if(rows[2] != null ) {
            	u.setCpf(rows[2].toString());            	
            }
            
            if(rows[3] != null ) {
            	u.setPerfil(rows[3].toString());            	
            }
            
            if(rows[4] != null ) {
            	u.setUserName(rows[4].toString());            	
            }
            
            if(rows[5] != null ) {
            	u.setIdSU(rows[5].toString());            	
            }
            
            if(rows[6] != null ) {
            	u.setNomeCompletoSu(rows[6].toString());            	
            }
            
            if(rows[7] != null ) {
            	u.setNomeSu(rows[7].toString());
            }
            
            listU.add(u);
        }
		
		
		return listU;
	}
	
	@GetMapping("/listaUsuariosComSubunidades/{id}")
	public List<?> listaUsuariosComSubunidades(@PathVariable(value="id") long id){
		
		List lista = usuarioRepository.listUsuariosComSubunidades(id);
		
		List l = lista;
        Iterator it =l.iterator();

        List<UsuarioComSu> listU = new ArrayList();
        
        while(it.hasNext()){
        	
        	UsuarioComSu u = new UsuarioComSu();
        
            Object rows[] = (Object[])it.next();
            
            if(rows[0] != null ) {
            	u.setUserId(rows[0].toString());            	
            }
            
            if(rows[1] != null ) {
            	u.setNome(rows[1].toString());            	
            }
            
            if(rows[2] != null ) {
            	u.setCpf(rows[2].toString());            	
            }
            
            if(rows[3] != null ) {
            	u.setPerfil(rows[3].toString());            	
            }
            
            if(rows[4] != null ) {
            	u.setUserName(rows[4].toString());            	
            }
            
            if(rows[5] != null ) {
            	u.setIdSU(rows[5].toString());            	
            }
            
            if(rows[6] != null ) {
            	u.setNomeCompletoSu(rows[6].toString());            	
            }
            
            if(rows[7] != null ) {
            	u.setNomeSu(rows[7].toString());
            }
            
            listU.add(u);
            
        }
        
        return listU;
	}
	
	@GetMapping("/listar/{id}")
	public Usuario listaUsuarioUnico(@PathVariable(value="id") long id){
		return usuarioRepository.findById(id);
	}
	
	@DeleteMapping("/excluir/{id}")
	public void excluirUsuario(@PathVariable(value="id") long id)  {
		usuarioRepository.deleteById(id);;
	}
	
	@PutMapping("/editar")
	public Usuario editarUsuario(@RequestBody Usuario usuario)  {
		
		long id = usuario.getId();
		
		Usuario u = usuarioRepository.findById(id);
		
		usuario.setSenha(u.getSenha());
		
		usuario.setSubunidade(null);
		
		return usuarioRepository.save(usuario);
		
	}
	
	@PutMapping("/editarComSu")
	public ResponseEntity<Usuario> editarUsuarioComSu(@RequestBody ResponseInsertSu<?> resp) {
		
		Usuario user = new Usuario();
		
		user = resp.getUsuario();
		
		long userId = user.getId();
		
		Usuario oldUser = usuarioRepository.findById(userId);
		
		long suId = resp.getSu(); 
		
		Subunidade su = subunidadeRepository.findById(suId);
		
		user.setSubunidade(su);
		user.setSenha(oldUser.getSenha());
		
		usuarioRepository.save(user);
		
		return ResponseEntity.ok(user);
		
	}
	
	
	@PostMapping("/verificarUsuario")
	public ResponseEntity<Response<Usuario>> verificarUsuario(@RequestBody Usuario usuario)  {
		
		long id = usuario.getId();
		
		Usuario u = usuarioRepository.findById(id);
		
		Response<Usuario> response = new Response<Usuario>();
		
		if( SenhaUtils.senhaValida(usuario.getSenha(), u.getSenha()) && u.getUserName().equals(usuario.getUserName()) ) {
			
			response.setMsg("Usuário encontrado");
			
			return ResponseEntity.ok().body(response);
			
		}else {
			response.getErrors().add("Usuário não encontrado");
			
			return ResponseEntity.badRequest().body(response);
			
		}
			
		
	}
	
	@PutMapping("/redefinirSenha")
	public Usuario redefinirSenha(@RequestBody Usuario usuario)  {
		
		long id = usuario.getId();
		
		Usuario u = usuarioRepository.findById(id);
		
		u.setSenha(SenhaUtils.gerarBCrypt(usuario.getSenha()));
		
		u.setSubunidade(null);
		
		return usuarioRepository.save(u);
		
	}

}

