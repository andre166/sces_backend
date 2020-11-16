package com.sgte.response;

import com.sgte.sce.security.entities.Usuario;

public class ResponseInsertSu <T> {
	
	private long su;
	
	private Usuario usuario;

	public long getSu() {
		return su;
	}

	public void setSu(long su) {
		this.su = su;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "ResponseInsertSu [su=" + su + ", usuario=" + usuario + "]";
	}
	

}
