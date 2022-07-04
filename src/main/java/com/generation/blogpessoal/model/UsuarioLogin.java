package com.generation.blogpessoal.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioLogin {
	
	private Long id;
	private String nome;
	private String usuario;
	private String senha;
	private String foto;
	private String tipo;
	private String token;
	
	public UsuarioLogin(Long id, String nome, String usuario, String senha, String foto, String token) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.foto = foto;
		this.token = token;
	}

	public UsuarioLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
