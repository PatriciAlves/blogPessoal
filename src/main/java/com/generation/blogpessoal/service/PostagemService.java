package com.generation.blogpessoal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;
import com.generation.blogpessoal.repository.TemaRepository;


@Service
public class PostagemService {
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	@Autowired
	private TemaRepository temaRepository;
	
	
	public Optional<Postagem> atualizaTema(Postagem postagem){
		if (postagemRepository.existsById(postagem.getId())
				&& temaRepository.existsById(postagem.getTema().getId())){

			return Optional.ofNullable(postagemRepository.save(postagem));
		}
		return Optional.empty();
	}

}
