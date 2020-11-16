package com.sgte.sce.security.dto;

public class JwtAuthenticationDto {

	private String userName;
	private String senha;

	public JwtAuthenticationDto() {
	}

	public String getSenha() {
		return senha;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "JwtAuthenticationRequestDto [userName=" + userName + ", senha=" + senha + "]";
	}

}
