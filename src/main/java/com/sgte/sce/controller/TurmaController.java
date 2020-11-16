package com.sgte.sce.controller;

import java.util.List;

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

import com.sgte.response.ResponseInsertTurma;
import com.sgte.sce.models.Subunidade;
import com.sgte.sce.models.Turma;
import com.sgte.sce.repository.SubunidadeRepository;
import com.sgte.sce.repository.TurmaRepository;

@RestController
@RequestMapping( value="/turma")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TurmaController {
	
	@Autowired
	TurmaRepository turmaRepository;
	
	@Autowired
	SubunidadeRepository subunidadeRepository;
	
	@GetMapping("/listar")
	public List<Turma> listaProdutos(){
		return turmaRepository.findAll();
	}
	
	@GetMapping("/listarPorSu/{id}")
	public List<Turma> listarTurmasPorSu(@PathVariable(value="id") long id){
		
		return turmaRepository.findAllBySu(id);
		
	}
	
	@GetMapping("/listar/{id}")
	public Turma listaTurmaUnico(@PathVariable(value="id") long id){
		return turmaRepository.findById(id);
	}
	
	@PostMapping("/salvar")
	public Turma salvaTurma(@RequestBody Turma turma) {
		return turmaRepository.save(turma);
	}
	
	@DeleteMapping("/excluir/{id}")
	public void excluirTurma(@PathVariable(value="id") long id)  {
		turmaRepository.deleteById(id);;
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Turma> salvarTurmaComSu(@RequestBody ResponseInsertTurma<?> resp) {
		
		Turma t = resp.getTurma();
		long idSu = resp.getSu();
		
		Subunidade su = subunidadeRepository.findById(idSu);
		t.setSubunidade(su);
		
		turmaRepository.save(t);
		
		return ResponseEntity.ok(t);
	}
	

}
