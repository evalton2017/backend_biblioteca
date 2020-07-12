package br.backend.api.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.backend.api.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	@Query(
		value="Select * from Livro as l where lower(concat(l.titulo, l.autor)) like %:pesquisa%",
		nativeQuery = true)
	List<Livro> findByTitulo(@Param("pesquisa") String pesquisa);
}

