package com.generation.blogpessoal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.blogpessoal.model.Tema;
import com.generation.blogpessoal.repository.TemaRepository;

@Service
public class TemaService {
	
	@Autowired
	private TemaRepository temaRepository;
	
	public Optional<Tema> atualizaTema(Tema tema){
		if (temaRepository.findById(tema.getId()).isPresent()) {
			Optional<Tema> buscaTema = temaRepository.findById(tema.getId());
			if ((buscaTema.isPresent()) && (buscaTema.get().getId() != tema.getId()))
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tema já existente no nosso sistema",
						null);
			return Optional.ofNullable(temaRepository.save(tema));
		}
		return Optional.empty();
	}
}
