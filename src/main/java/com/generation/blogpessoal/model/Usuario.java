package com.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name= "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotNull(message = "Informe o nome do usuario")
	private String nome;
	
	@Schema(example = "email@email.com.br")
	@NotNull(message = "O atributo Usuário é Obrigatório!")
	@Email(message = "O atributo Usuário deve ser um email válido!")
	private String usuario;
	
	@NotNull(message = "Informe uma senha de no min 8 caracteres")
	@Size(min=8, message = "a senha deve conter mo min 8 caracteres")
	private String senha;
	
	private String foto;
	
	private String tipo;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	public List<Postagem> postagem;
	
	// Primeiro método Construtor

		public Usuario(Long id, String nome, String usuario, String senha, String foto) {
			this.id = id;
			this.nome = nome;
			this.usuario = usuario;
			this.senha = senha;
			this.foto = foto;
		}

		// Segundo método Construtor

		public Usuario() {	}


}
