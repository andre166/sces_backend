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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sgte.sce.models.enums.CidadaosStatus;

@Entity
@Table(name="TB_CIDADAO")
@JsonIgnoreProperties("inspection")
public class Cidadao implements Serializable{
	
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nomeCompleto;
	
	private String cpf;
	
	private String rg;
	
	private String genero;
	
	private String dataDeNascimento;
	
	private String email;
	
	private String nomeMae;
	
	private String nomePai;
	
	private String estadoCivil;
	
	private Integer cidadaosStatus;
	
	private String nomeDeGuerra;
	
	private String ra;
	
	private String tipo;
	
	private String telefone;
	
	private String qm;
	
	private String comportamento;
	
	private String dataDePraca;
	
	private String postGrad;
	
	private String numeroRecruta;
	
//	@OneToOne(mappedBy = "cidadao", cascade = CascadeType.ALL)
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cidadao", referencedColumnName = "id")
	@JsonBackReference(value="user-movement")
	@OneToOne(mappedBy = "cidadao", cascade = CascadeType.REMOVE)
	private Endereco endereco;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="fk_turma")
	private Turma turma = new Turma();
	
	//Constructor
	public Cidadao() {
		super();
	}

	public Cidadao(Long id, String nomeCompleto, String cpf, String rg, String genero, String dataDeNascimento,
			String email, String nomeMae, String nomePai, String estadoCivil, CidadaosStatus cidadaosStatus, Turma turma) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.rg = rg;
		this.genero = genero;
		this.dataDeNascimento = dataDeNascimento;
		this.email = email;
		this.nomeMae = nomeMae;
		this.nomePai = nomePai;
		this.estadoCivil = estadoCivil;
		setCidadaosStatus(cidadaosStatus);
		this.turma = turma;
	}

	//Get e Set
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public CidadaosStatus getCidadaosStatus() {
		return CidadaosStatus.valueOf(cidadaosStatus);
	}

	public void setCidadaosStatus(CidadaosStatus cidadaosStatus) {
	
		if( cidadaosStatus != null ) {
			this.cidadaosStatus = cidadaosStatus.getCode();			
		}
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNomeDeGuerra() {
		return nomeDeGuerra;
	}

	public void setNomeDeGuerra(String nomeDeGuerra) {
		this.nomeDeGuerra = nomeDeGuerra;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getQm() {
		return qm;
	}

	public void setQm(String qm) {
		this.qm = qm;
	}

	public String getComportamento() {
		return comportamento;
	}

	public void setComportamento(String comportamento) {
		this.comportamento = comportamento;
	}

	public String getDataDePraca() {
		return dataDePraca;
	}

	public void setDataDePraca(String dataDePraca) {
		this.dataDePraca = dataDePraca;
	}

	public String getPostGrad() {
		return postGrad;
	}

	public void setPostGrad(String postGrad) {
		this.postGrad = postGrad;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public String getNumeroRecruta() {
		return numeroRecruta;
	}

	public void setNumeroRecruta(String numeroRecruta) {
		this.numeroRecruta = numeroRecruta;
	}

	@Override
	public String toString() {
		return "Cidadao [id=" + id + ", nomeCompleto=" + nomeCompleto + ", cpf=" + cpf + ", rg=" + rg + ", genero="
				+ genero + ", dataDeNascimento=" + dataDeNascimento + ", email=" + email + ", nomeMae=" + nomeMae
				+ ", nomePai=" + nomePai + ", estadoCivil=" + estadoCivil + ", cidadaosStatus=" + cidadaosStatus
				+ ", nomeDeGuerra=" + nomeDeGuerra + ", ra=" + ra + ", telefone=" + telefone + ", qm=" + qm
				+ ", comportamento=" + comportamento + ", dataDePraca=" + dataDePraca + ", postGrad=" + postGrad
				+ ", endereco=" + endereco + ", turma=" + turma + "]";
	}
	
	

	
}
