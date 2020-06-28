package br.backend.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.backend.api.entity.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>{
	
	@Transactional
	public List<Telefone> findByUserId(Long id);
	

}
