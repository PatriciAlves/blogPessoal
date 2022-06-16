package com.generation.blogpessoal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.model.Usuario;
import com.generation.blogpessoal.repository.PostagemRepository;
import com.generation.blogpessoal.repository.TemaRepository;
import com.generation.blogpessoal.repository.UsuarioRepository;

@Service
public class PostagemService {

	@Autowired
	private PostagemRepository postagemRepository;

	@Autowired
	private TemaRepository temaRepository;



	public ResponseEntity<Postagem> atualizaPostagem(Postagem postagem) {
		if (postagemRepository.existsById(postagem.getId())) {

			if (temaRepository.existsById(postagem.getTema().getId()))
				return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
