package com.sgte.sce.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sgte.sce.security.entities.Usuario;

@Entity
@Table(name="TB_SUBUNIDADE")
public class Subunidade implements Serializable{
	
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nomeSubunidade;
	
	private String nomeCompleto;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="fk_om")
	private Om om;
	
	@JsonIgnore
//	@JsonManagedReference
	@OneToMany(mappedBy ="subunidade" )
	private List<Usuario> usuario = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy ="subunidade" )
	private List<Turma> turma = new ArrayList<>();

	//Constructor
	
	public Subunidade() {
		super();
	}

	public Subunidade(Long id, String nomeSubunidade, Om om) {
		super();
		this.id = id;
		this.nomeSubunidade = nomeSubunidade;
		this.om = om;

	}
	
	// GET E SET 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeSubunidade() {
		return nomeSubunidade;
	}

	public void setNomeSubunidade(String nomeSubunidade) {
		this.nomeSubunidade = nomeSubunidade;
	}

	public Om getOm() {
		return om;
	}

	public void setOm(Om om) {
		this.om = om;
	}

//	public List<Cidadao> getCidadao() {
//		return cidadao;
//	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public List<Turma> getTurma() {
		return turma;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	@Override
	public String toString() {
		return "Subunidade [id=" + id + ", nomeSubunidade=" + nomeSubunidade + ", nomeCompleto=" + nomeCompleto
				+ ", om=" + om + "]";
	}

	
	
	
}
