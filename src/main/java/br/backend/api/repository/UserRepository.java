package br.backend.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.backend.api.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Transactional
	public User findByEmail(String email);
	

}
