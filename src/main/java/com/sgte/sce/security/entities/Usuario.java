package com.sgte.sce.security.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sgte.sce.models.Om;
import com.sgte.sce.models.Subunidade;
import com.sgte.sce.security.enums.PerfilEnum;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 306411570471828345L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String userName;
	
	private String senha;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil")
	private PerfilEnum perfil;

//	@JsonIgnore
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="fk_om")
	private Om om;
	
//	@JsonBackReference
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="fk_subunidade")
	private Subunidade subunidade;
	
	public Usuario() {
	}

	
	public Usuario(Long id, String nome, String cpf, String userName, String senha, PerfilEnum perfil) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.userName = userName;
		this.senha = senha;
		this.perfil = perfil;
	}
	
	
	public Usuario(Long id, String nome, String cpf, String userName, String senha, PerfilEnum perfil, Om om) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.userName = userName;
		this.senha = senha;
		this.perfil = perfil;
		this.om = om;
	}
	
	public Usuario(Long id, String nome, String cpf, String userName, String senha, PerfilEnum perfil, Om om, Subunidade subunidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.userName = userName;
		this.senha = senha;
		this.perfil = perfil;
		this.om = om;
		this.subunidade = subunidade;
	}
	
	
	
	//Getter e setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "username")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Enumerated(EnumType.STRING)
	public PerfilEnum getPerfil() {
		return perfil;
	}
	
	@Enumerated(EnumType.STRING)
	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	@Column(name = "senha")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Om getOm() {
		return om;
	}

	public void setOm(Om om) {
		this.om = om;
	}


	public Subunidade getSubunidade() {
		return subunidade;
	}


	public void setSubunidade(Subunidade subunidade) {
		this.subunidade = subunidade;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", userName=" + userName + ", senha=" + senha
				+ ", perfil=" + perfil + ", om=" + om + ", subunidade=" + subunidade + "]";
	}
	
	
	

}
