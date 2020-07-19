package br.backend.api.livro.vinculolivroeditora;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemVinculoRepository extends JpaRepository<ItemEditoraLivro, Long> {
		
	@Query(value="select max(posicao) from item_editora_livro",
			nativeQuery = true)
		Long findByPosicao();

}
