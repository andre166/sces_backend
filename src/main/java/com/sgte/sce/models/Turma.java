package com.sgte.sce.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

@Entity
@Table(name="TB_Turma")
public class Turma implements Serializable{
	
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String turma;
	
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy ="turma", cascade = CascadeType.REMOVE)
	private List<Cidadao> cidadao = new ArrayList<>();
	//Constructor
	

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="fk_subunidade")
	private Subunidade subunidade;
	
	
//	@OneToOne
//	@MapsId
//	private Cidadao cidadao;

//	@OneToOne(mappedBy = "cidadao", cascade = CascadeType.ALL)
//	private Telefone telefone;
	
	public Turma() {
		super();
	}

	public Turma(Long id, String turma, Subunidade subunidade) {
		super();
		this.id = id;
		this.turma = turma;
		this.subunidade = subunidade;
	}

	//Get e Set
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

//	public List<Cidadao> getCidadao() {
//		return cidadao;
//	}
//
//	public void setCidadao(List<Cidadao> cidadao) {
//		this.cidadao = cidadao;
//	}

	public Subunidade getSubunidade() {
		return subunidade;
	}

	public void setSubunidade(Subunidade subunidade) {
		this.subunidade = subunidade;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", turma=" + turma + ", cidadao=" + cidadao + ", subunidade=" + subunidade + "]";
	}

	
}
