package com.sgte.sce.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sgte.sce.security.entities.Usuario;

@Entity
@Table(name="TB_OM")
public class Om implements Serializable{
	
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nomeOm")
	private String nomeOm;
	
	private String cnpj;
	
	private String cep;
	
	@Column(name = "nomeAbrev")
	private String nomeAbrev;
	
//	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy ="om", cascade = CascadeType.ALL )
	private List<Usuario> usuario = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy ="om", cascade = CascadeType.ALL )
	private List<Subunidade> subunidades = new ArrayList<>();

	//constructor
	public Om() {
		super();
	}

	public Om(Long id, String nomeOm ) {
		super();
		this.id = id;
		this.nomeOm = nomeOm;
	}

	// GET E SET 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="nomeOm")
	public String getNomeOm() {
		return nomeOm;
	}
	@Column(name="nomeOm")
	public void setNomeOm(String nomeOm) {
		this.nomeOm = nomeOm;
	}

	public List<Subunidade> getSubunidades() {
		return subunidades;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name="nomeAbrev")
	public String getNomeAbrev() {
		return nomeAbrev;
	}
	@Column(name="nomeOm")
	public void setNomeAbrev(String nomeAbrev) {
		this.nomeAbrev = nomeAbrev;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	
}
