package com.sgte.sce.models.enums;

public enum CidadaosStatus {
	
	OK(0),
	BAIXADO(1),
	FERIAS(2),
	DISPENSADO(3),
	MISSAO(4),
	PUNIDO(5),
	OUTROS(6);
	
	private int code;
	
	private CidadaosStatus(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}
	
	public static CidadaosStatus valueOf(int code) {
		for( CidadaosStatus value : CidadaosStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código CidadaosStatus inválido");
	}
}
