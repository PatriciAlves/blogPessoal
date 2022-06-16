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
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public ResponseEntity<Postagem> atualizaPostagem(Postagem postagem) {
		Optional<Usuario> atualizaPostagem = usuarioRepository.findById(postagem.getUsuario().getId());
		if (atualizaPostagem.isPresent() && (postagemRepository.existsById(postagem.getId()))) {
			return temaRepository.findById(postagem.getTema().getId())
					.map(resp -> ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem)))
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "O tema não existe", null));
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Usuário não existe!", null);
	}
}
