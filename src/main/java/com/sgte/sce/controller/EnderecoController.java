package com.sgte.sce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgte.sce.models.Endereco;
import com.sgte.sce.repository.EnderecoRepository;

@RestController
@RequestMapping( value="/endereco")
public class EnderecoController {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@GetMapping("/listar")
	public List<Endereco> listaProdutos(){
		return enderecoRepository.findAll();
	}
	
	@GetMapping("/listar/{id}")
	public Endereco listaEnderecoUnico(@PathVariable(value="id") long id){
		return enderecoRepository.findById(id);
	}
	
	@PostMapping("/salvar")
	public Endereco salvaEndereco(@RequestBody Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	@DeleteMapping("/excluir/{id}")
	public void excluirEndereco(@PathVariable(value="id") long id)  {
		enderecoRepository.deleteById(id);;
	}
	
	@PutMapping("/editar")
	public Endereco editarEndereco(@RequestBody Endereco endereco)  {
		return enderecoRepository.save(endereco);
	}
	
	

}
