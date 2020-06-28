package br.backend.api.entity.dto.telefone;

import org.mapstruct.Mapper;

import br.backend.api.entity.Telefone;
import br.backend.api.entity.tools.AbstractMapper;

@Mapper(componentModel = "spring")
public interface TelefoneMapper extends AbstractMapper<Telefone, TelefoneDTO> {

}
