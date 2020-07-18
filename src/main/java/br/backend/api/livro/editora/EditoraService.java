package br.backend.api.livro.editora;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EditoraService {

	@Autowired
	EditoraRepository editoraRepo;
	
	public List<Editora> listar(){
		List<Editora> Editoras = editoraRepo.findAll();
		return Editoras;
	}
	
	public Editora salvar(Editora Editora) {
		return  Editora = editoraRepo.save(Editora);
	}
	
	
	public Editora buscarPorId(Long id) throws Exception {
		Optional<Editora> Editora = editoraRepo.findById(id);
		return Editora.orElseThrow(()-> new Exception(
				"Editora não encontrada Id:"+id+",: "+ Editora.class.getName()));
	}
}
