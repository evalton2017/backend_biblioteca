package br.backend.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.backend.api.entity.Telefone;
import br.backend.api.entity.User;
import br.backend.api.repository.TelefoneRepository;

@Service
public class TelefoneService {
	
	@Autowired
	TelefoneRepository repo;
	
	public Telefone buscarPorId(Long id) throws Exception {
		Optional<Telefone> telefone = repo.findById(id);
		return telefone.orElseThrow(()-> new Exception(
				"Telefone não encontrada Id:"+id+",: "+ User.class.getName()));
	}

}
