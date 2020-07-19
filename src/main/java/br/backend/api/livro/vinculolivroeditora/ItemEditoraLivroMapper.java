package br.backend.api.livro.vinculolivroeditora;

import org.mapstruct.Mapper;

import br.backend.api.entity.tools.AbstractMapper;

@Mapper(componentModel = "spring")
public interface ItemEditoraLivroMapper extends AbstractMapper<ItemEditoraLivro, ItemVinculoDTO> {

}
