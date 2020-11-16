package com.sgte.response;

import java.util.ArrayList;
import java.util.List;

import com.sgte.sce.security.entities.Usuario;

public class Response<T> {

	private T data;
	private List<String> errors;
	private String msg;
	
	private Usuario usuario;

	public Response() {
	}
	

	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Response [data=" + data + ", errors=" + errors + "]";
	}
	
	

}
