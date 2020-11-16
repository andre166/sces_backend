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
//import com.sgte.sce.models.Idioma;
//import com.sgte.sce.repository.IdiomaRepository;
//
//@RestController
//@RequestMapping( value="/Idioma")
//public class IdiomaController {
//	
//	@Autowired
//	IdiomaRepository idiomaRepository;
//	
//	@GetMapping("/listar")
//	public List<Idioma> listaProdutos(){
//		return idiomaRepository.findAll();
//	}
//	
//	@GetMapping("/listar/{id}")
//	public Idioma listaIdiomaUnico(@PathVariable(value="id") long id){
//		return idiomaRepository.findById(id);
//	}
//	
//	@PostMapping("/salvar")
//	public Idioma salvaIdioma(@RequestBody Idioma idioma) {
//		return idiomaRepository.save(idioma);
//	}
//	
//	@DeleteMapping("/excluir/{id}")
//	public void excluirIdioma(@PathVariable(value="id") long id)  {
//		idiomaRepository.deleteById(id);;
//	}
//	
//	@PutMapping("/editar")
//	public Idioma editarIdioma(@RequestBody Idioma idioma)  {
//		return idiomaRepository.save(idioma);
//	}
//
//}
