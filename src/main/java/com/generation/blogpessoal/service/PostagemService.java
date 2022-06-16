package com.generation.blogpessoal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;


@Service
public class PostagemService {

	@Autowired
	private PostagemRepository postagemRepository;


	public Optional<Postagem> atualizaPostagem(Postagem postagem) {
		if (postagemRepository.findById(postagem.getId()).isPresent()) {
			Optional<Postagem> buscaPostagem = postagemRepository.findById(postagem.getId());

			if ((buscaPostagem.isPresent()) && (buscaPostagem.get().getTema().getId() != postagem.getId()))
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tema já existente no nosso sistema", null);

			return Optional.ofNullable(postagemRepository.save(postagem));
		}
		return Optional.empty();
	}

}
