//package com.sgte.sce.models;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//@Entity
//@Table(name="TB_IDIOMA")
//public class Idioma implements Serializable{
//	
//	private static final long serialVersionUID = 1l;
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
//	
//	private String idioma; 
//	
//	@JsonBackReference
//	@ManyToOne
//	@JoinColumn(name="fk_cidadao")
//	private Cidadao cidadao;
//
//	//Constructor
//	
//	public Idioma() {
//		super();
//	}
//	
//	public Idioma(Long id, String idioma, Cidadao cidadao) {
//		super();
//		this.id = id;
//		this.idioma = idioma;
//		this.cidadao = cidadao;
//	}
//
//	//Get e Set
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getIdioma() {
//		return idioma;
//	}
//
//	public void setIdioma(String idioma) {
//		this.idioma = idioma;
//	}
//
//	public Cidadao getCidadao() {
//		return cidadao;
//	}
//
//	public void setCidadao(Cidadao cidadao) {
//		this.cidadao = cidadao;
//	}
//	
//}
