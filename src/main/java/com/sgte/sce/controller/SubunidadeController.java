package com.sgte.sce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgte.sce.models.Subunidade;
import com.sgte.sce.repository.SubunidadeRepository;

@RestController
@RequestMapping( value="/subunidade")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SubunidadeController {
	
	@Autowired
	SubunidadeRepository subunidadeRepository;
	
	@GetMapping("/listar")
	public List<Subunidade> listaProdutos(){
		return subunidadeRepository.findAll();
	}
	
	@GetMapping("/listarPorOm/{id}")
	public List<Subunidade> listarPorOm(@PathVariable(value="id") long id){
		
		return subunidadeRepository.listarPorOm(id);
		
	}
	
	@GetMapping("/listar/{id}")
	public Subunidade listaSubunidadeUnico(@PathVariable(value="id") long id){
		return subunidadeRepository.findById(id);
	}
	
	@PostMapping("/salvar")
	public Subunidade salvarSubunidade(@RequestBody Subunidade subunidade) {
		return subunidadeRepository.save(subunidade);
	}
	
	@DeleteMapping("/excluir/{id}")
	public void excluirSubunidade(@PathVariable(value="id") long id)  {
		subunidadeRepository.deleteById(id);;
	}
	
	@PutMapping("/editar")
	public Subunidade editarSubunidade(@RequestBody Subunidade subunidade)  {
		return subunidadeRepository.save(subunidade);
	}

}
