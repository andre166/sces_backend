//package com.sgte.sce.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sgte.sce.models.Telefone;
//import com.sgte.sce.repository.TelefoneRepository;
//
//@RestController
//@RequestMapping( value="/telefone")
//public class TelefoneController {
//	
//	@Autowired
//	TelefoneRepository telefoneRepository;
//	
//	@GetMapping("/listar")
//	public List<Telefone> listaProdutos(){
//		return telefoneRepository.findAll();
//	}
//	
//	@GetMapping("/listar/{id}")
//	public Telefone listaTelefonesUnico(@PathVariable(value="id") long id){
//		return telefoneRepository.findById(id);
//	}
//	
//	@PostMapping("/salvar")
//	public Telefone salvarTelefones(@RequestBody Telefone telefone) {
//		return telefoneRepository.save(telefone);
//	}
//	
//	@DeleteMapping("/excluir/{id}")
//	public void excluirTelefones(@PathVariable(value="id") long id)  {
//		telefoneRepository.deleteById(id);;
//	}
//	
//	@PutMapping("/editar")
//	public Telefone editarTelefones(@RequestBody Telefone telefone)  {
//		return telefoneRepository.save(telefone);
//	}
//
//}
