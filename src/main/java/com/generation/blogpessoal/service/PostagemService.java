package com.generation.blogpessoal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	
	public Optional<Postagem> atualizaPostagem(Postagem postagem){
		if (postagemRepository.existsById(postagem.getId())&&
			temaRepository.existsById(postagem.getTema().getId()))
		{
			Optional<Postagem> buscaPostagem = postagemRepository.findByPostagem(postagem.getTexto());
			if ((buscaPostagem.isPresent()) && (buscaPostagem.get().getId() != postagem.getId()))
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Falha ao atualizar",
						null);
			
			return Optional.ofNullable(postagemRepository.save(postagem));
		}
		return Optional.empty();
	}

}
