package com.generation.blogpessoal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;
import com.generation.blogpessoal.repository.TemaRepository;

@Service
public class PostagemService {

	@Autowired
	private PostagemRepository postagemRepository;

	@Autowired
	private TemaRepository temaRepository;

	public ResponseEntity<Postagem> atualizaPostagem(Postagem postagem) {
		Optional<Postagem> atualizaPostagem = postagemRepository.findById(postagem.getUsuario().getId());
		if (atualizaPostagem.isPresent() && (postagemRepository.existsById(postagem.getId()))) {
			return temaRepository.findById(postagem.getTema().getId())
					.map(resp -> ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem)))
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "O tema não existe", null));
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Usuário não existe!", null);
	}
}
