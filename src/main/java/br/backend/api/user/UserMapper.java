package br.backend.api.user;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import br.backend.api.entity.tools.AbstractMapper;
import br.backend.api.livro.LivroMapper;
import br.backend.api.user.telefone.TelefoneMapper;

@Mapper(componentModel = "spring", uses = {TelefoneMapper.class, LivroMapper.class})
public interface UserMapper extends AbstractMapper<User, UserDTO> {

	 @InheritInverseConfiguration(name = "toDto")
	 void updateModel(UserUpdateDTO dto, @MappingTarget User entity);
}
