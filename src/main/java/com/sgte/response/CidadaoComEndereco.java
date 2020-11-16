package com.sgte.response;

import com.sgte.sce.models.Cidadao;
import com.sgte.sce.models.Endereco;

public class CidadaoComEndereco <T> {

	private Cidadao cidadao;
	private Endereco endereco;
	
	public Cidadao getCidadao() {
		return cidadao;
	}
	
	public void setCidadao(Cidadao cidadao) {
		this.cidadao = cidadao;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		return "CidadaoComEndereco [cidadao=" + cidadao + ", endereco=" + endereco + "]";
	}
	
	
	
	

}
