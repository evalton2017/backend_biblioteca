package br.backend.api.entity.dto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import br.backend.api.entity.User;
import br.backend.api.entity.dto.livro.LivroMapper;
import br.backend.api.entity.dto.telefone.TelefoneMapper;
import br.backend.api.entity.tools.AbstractMapper;

@Mapper(componentModel = "spring", uses = {TelefoneMapper.class, LivroMapper.class})
public interface UserMapper extends AbstractMapper<User, UserDTO> {

	 @InheritInverseConfiguration(name = "toDto")
	 void updateModel(UserUpdateDTO dto, @MappingTarget User entity);
}
