package com.generation.blogpessoal.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="tb_postagens")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O título é obrigatorio e não pode ser co espaços em branco)")
	@Size(min = 5, max = 100, message = "título deve conter no min 5 caracteres e no máximo 100")
	private String titulo;

	@NotNull(message = "O texto é obrigatorio e não pode ser co espaços em branco)")
	@Size(min = 15, max = 1000, message = "texto deve conter no min 15 caracteres e no máximo 1000")
	private String texto;
	
	@UpdateTimestamp //trás a data de forma automática
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	public Usuario usuario;
	
	
}
