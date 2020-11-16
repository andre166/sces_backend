package com.sgte.response;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sgte.sce.models.Om;
import com.sgte.sce.models.Subunidade;
import com.sgte.sce.security.entities.Usuario;
import com.sgte.sce.security.enums.PerfilEnum;

public class UsuarioComSu implements Serializable {

	private static final long serialVersionUID = 306411570471828345L;

	private String userId;
	private String cpf;
	private String Perfil;
	private String userName;
	private String idSU;
	private String nomeCompletoSu;
	private String nomeSu;
	private String nome;
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIdSU() {
		return idSU;
	}

	public void setIdSU(String idSU) {
		this.idSU = idSU;
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
	public String getPerfil() {
		return Perfil;
	}
	public void setPerfil(String perfil) {
		Perfil = perfil;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNomeCompletoSu() {
		return nomeCompletoSu;
	}
	public void setNomeCompletoSu(String nomeCompletoSu) {
		this.nomeCompletoSu = nomeCompletoSu;
	}
	public String getNomeSu() {
		return nomeSu;
	}
	public void setNomeSu(String nomeSu) {
		this.nomeSu = nomeSu;
	}

	@Override
	public String toString() {
		return "UsuarioComSu [userId=" + userId + ", cpf=" + cpf + ", Perfil=" + Perfil + ", userName=" + userName
				+ ", idSU=" + idSU + ", nomeCompletoSu=" + nomeCompletoSu + ", nomeSu=" + nomeSu + ", nome=" + nome
				+ "]";
	}
	
	

}
