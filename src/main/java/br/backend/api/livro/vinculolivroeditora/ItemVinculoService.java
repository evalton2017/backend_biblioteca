package br.backend.api.livro.vinculolivroeditora;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.backend.api.exception.ExceptionErros;


@Service
public class ItemVinculoService {
	@Autowired
	ItemVinculoRepository repo;

	@Autowired
	ItemEditoraLivroMapper mapper;
	
	public List<ItemEditoraLivro> listar(){
		List<ItemEditoraLivro> ItemEditoraLivros = repo.findAll();
		return ItemEditoraLivros;
	}
	
	public ItemEditoraLivro salvar(ItemVinculoDTO dto) {
		Long posicao = verificaPosicao();
		ItemEditoraLivro vinculo = mapper.toEntity(dto);
		vinculo.setPosicao(posicao);
		return  vinculo = repo.save(vinculo);
	}
	
	
	public ItemEditoraLivro buscarPorId(Long id) throws Exception {
		Optional<ItemEditoraLivro> ItemEditoraLivro = repo.findById(id);
		return ItemEditoraLivro.orElseThrow(()-> new Exception(
				"ItemEditoraLivro não encontrada Id:"+id+",: "+ ItemEditoraLivro.class.getName()));
	}
	
	public Long verificaPosicao() {
		Long num = repo.findByPosicao();		
		return (num==null?num=1L:num+1L);
	}
	
	public void update(List<ItemUpdateDTO> lista) throws ExceptionErros {		
		lista.forEach((v)->{
			ItemEditoraLivro vinculo = new ItemEditoraLivro();
			try {
				vinculo = buscarPorId(v.getId());
				vinculo.setPosicao(v.getPosicao());
				repo.save(vinculo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		});
	}

}
