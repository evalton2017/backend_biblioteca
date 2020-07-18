package br.backend.api.user.telefone;

import org.mapstruct.Mapper;

import br.backend.api.entity.tools.AbstractMapper;

@Mapper(componentModel = "spring")
public interface TelefoneMapper extends AbstractMapper<Telefone, TelefoneDTO> {

}
