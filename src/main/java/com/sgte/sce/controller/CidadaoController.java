package com.sgte.sce.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

import com.sgte.response.CidadaoComEndereco;
import com.sgte.sce.models.Cidadao;
import com.sgte.sce.models.Endereco;
import com.sgte.sce.models.Turma;
import com.sgte.sce.models.enums.CidadaosStatus;
import com.sgte.sce.repository.CidadaoRepository;
import com.sgte.sce.repository.EnderecoRepository;
import com.sgte.sce.repository.TurmaRepository;

@RestController
@RequestMapping( value="/cidadao")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CidadaoController {
	
	@Autowired
	CidadaoRepository cidadaoRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	TurmaRepository turmaRepository;
	
	@GetMapping("/listar")
	public List<Cidadao> listaProdutos(){
		return cidadaoRepository.findAll();
	}
	
	@GetMapping("/listar/{id}")
	public Cidadao listaCidadaoUnico(@PathVariable(value="id") long id){
		return cidadaoRepository.findById(id);
	}
	
	@PostMapping("/salvar")
	public Cidadao salvaCidadao(@RequestBody CidadaoComEndereco<?> cidadaoComEndereco) {
		
		System.out.println(cidadaoComEndereco);
		
		Turma reqTurma = cidadaoComEndereco.getCidadao().getTurma();
		
		Turma t = turmaRepository.findById( reqTurma.getId()).get();
		
		Endereco e = new Endereco();
		Cidadao c = new Cidadao();
		
		CidadaosStatus cidadadoStatusNumber = cidadaoComEndereco.getCidadao().getCidadaosStatus();
		
		c = cidadaoComEndereco.getCidadao();
		e = cidadaoComEndereco.getEndereco();
		
		c.setCidadaosStatus(cidadadoStatusNumber);
		c.setTurma(t);
		
		Cidadao novoCidadao = cidadaoRepository.save(c);
		
		e.setCidadao(novoCidadao);
		
		
		enderecoRepository.save(e);

		return null;
		
	}
	
	@DeleteMapping("/excluir/{id}")
	public void excluirCidadao(@PathVariable(value="id") long id)  {
		cidadaoRepository.deleteById(id);;
	}
	
	@PutMapping("/editar")
	public Cidadao editarCidadao(@RequestBody Cidadao cidadao)  {
		return cidadaoRepository.save(cidadao);
	}
	
	
	@GetMapping("/listarPorTurma/{id}")
	public List<Cidadao> listarCidadaoPorTurma(@PathVariable(value="id") long id){

		Turma t = turmaRepository.findById(id);
		
		return cidadaoRepository.findByTurma(t.getId());
		
	}
	
	@GetMapping("/listarComEndereco/{id}")
	public CidadaoComEndereco<?> listarCidadaoComEndereco(@PathVariable(value="id") long id){
		
		List l = cidadaoRepository.findCidadaoComEndereco(id);
			
        Iterator it = l.iterator();
       
        CidadaoComEndereco ce = new CidadaoComEndereco();
        
        Cidadao c = new Cidadao();
        Endereco e = new Endereco();
        
    	while(it.hasNext()){
        
            Object rows[] = (Object[])it.next();

            if(rows[0] != null ) {
            	Long cidadaoId = Long.parseLong(rows[0].toString());
            	c.setId(cidadaoId);
            		
            }
            
            if(rows[1] != null ) {
            	
            	int status = Integer.parseInt(rows[1].toString());
            	
            	c.setCidadaosStatus( CidadaosStatus.valueOf(status) );
            }
            
            if(rows[2] != null ) {
            	c.setComportamento(rows[2].toString());
            }
            
            if(rows[3] != null ) {
            	c.setCpf(rows[3].toString());
            }
            
            if(rows[4] != null ) {
            	c.setDataDeNascimento(rows[4].toString());
            }
            
            if(rows[5] != null ) {
            	c.setDataDePraca(rows[5].toString());
            }
            
            if(rows[6] != null ) {
            	c.setEmail(rows[6].toString());
            }
            
            if(rows[7] != null ) {
            	c.setEstadoCivil(rows[7].toString());
            }
            
            if(rows[8] != null ) {
            	c.setGenero(rows[8].toString());
            }
            
            if(rows[9] != null ) {
            	c.setNomeCompleto(rows[9].toString());
            }
            
            if(rows[10] != null ) {
            	c.setNomeDeGuerra(rows[10].toString());
            }
            
            if(rows[11] != null ) {
            	c.setNomeMae(rows[11].toString());
            }
            
            if(rows[12] != null ) {
            	c.setNomePai(rows[12].toString());
            }
            
            if(rows[13] != null ) {
            	c.setPostGrad(rows[13].toString());
            }
            
            if(rows[14] != null ) {
            	c.setQm(rows[14].toString());
            }
            
            if(rows[15] != null ) {
            	c.setRa(rows[15].toString());
            }
            
            if(rows[16] != null ) {
            	c.setRg(rows[16].toString());
            }
            
            if(rows[17] != null ) {
            	c.setTelefone(rows[17].toString());
            }
            
            if(rows[18] != null ) {
            	c.setTipo(rows[18].toString());
            }
            
            if(rows[19] != null ) {
            	e.setBairro(rows[19].toString());
            }
            
            if(rows[20] != null ) {
            	e.setCidade(rows[20].toString());
            }
            
            if(rows[21] != null ) {
            	e.setEstado(rows[21].toString());
            }
            
            if(rows[22] != null ) {
            	e.setRua(rows[22].toString());
            }
            
            if(rows[23] != null ) {
            	c.setNumeroRecruta(rows[23].toString());
            }
            
            if(rows[24] != null ) {
            	Long enderecoId = Long.parseLong(rows[24].toString());
            	e.setId(enderecoId);
            }
            
            
        }
    	
    	ce.setCidadao(c);
    	ce.setEndereco(e);
		
		return ce;
		
	}

}
