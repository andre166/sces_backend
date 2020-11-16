//package com.sgte.sce.models;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.MapsId;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="TB_TELEFONE")
//public class Telefone implements Serializable{
//	
//	private static final long serialVersionUID = 1l;
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
//	
//	private String tipo;
//	
//	private String telefone;
//	
//	@OneToOne
//	@MapsId
//	private Cidadao cidadao;
//
//	//Constructor
//	
//	public Telefone() {
//		super();
//	}
//
//
//	public Telefone(Long id, String tipo, String telefone, Cidadao cidadao) {
//		super();
//		this.id = id;
//		this.tipo = tipo;
//		this.telefone = telefone;
//		this.cidadao = cidadao;
//	}
//
//	// GET E SET 
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getTipo() {
//		return tipo;
//	}
//
//	public void setTipo(String tipo) {
//		this.tipo = tipo;
//	}
//
//	public String getTelefone() {
//		return telefone;
//	}
//
//	public void setTelefone(String telefone) {
//		this.telefone = telefone;
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
