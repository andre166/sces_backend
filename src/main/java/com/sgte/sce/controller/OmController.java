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

import com.sgte.sce.models.Om;
import com.sgte.sce.repository.OmRepository;

@RestController
@RequestMapping( value="/om")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OmController {
	
	@Autowired
	OmRepository omRepository;
	
	@GetMapping("/listar")
	public List<Om> listaProdutos(){
		return omRepository.findAll();
	}
	
	@GetMapping("/listar/{id}")
	public Om listaOmUnico(@PathVariable(value="id") long id){
		return omRepository.findById(id);
	}
	
	@PostMapping("/salvar")
	public Om salvarOm(@RequestBody Om om) {
		return omRepository.save(om);
	}
	
	@DeleteMapping("/excluir/{id}")
	public void excluirOm(@PathVariable(value="id") long id)  {
		omRepository.deleteById(id);;
	}
	
	@PutMapping("/editar")
	public Om editarOm(@RequestBody Om om)  {
		return omRepository.save(om);
	}

}
