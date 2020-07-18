package br.backend.api.user.telefone;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>{
	
	@Transactional
	public List<Telefone> findByUserId(Long id);
	

}
