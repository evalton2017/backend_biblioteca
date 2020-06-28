package br.backend.api.entity.dto.livro;

import org.mapstruct.Mapper;

import br.backend.api.entity.Livro;
import br.backend.api.entity.tools.AbstractMapper;

@Mapper(componentModel = "spring")
public interface LivroMapper extends AbstractMapper<Livro, LivroDTO>{

}
