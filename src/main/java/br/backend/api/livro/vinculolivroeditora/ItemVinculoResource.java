package br.backend.api.livro.vinculolivroeditora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/vinculoEditora")
public class ItemVinculoResource {
	
	@Autowired
	ItemVinculoService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ItemEditoraLivro>> listar(){
		List<ItemEditoraLivro> ItemEditoraLivro = service.listar();
		return ResponseEntity.ok().body(ItemEditoraLivro);
	}
	
//	@RequestMapping(value="/{pesquisa}",method=RequestMethod.GET)
//	public ResponseEntity<List<Editora>> buscarEditora(@PathVariable("pesquisa") String pesquisa){
//		List<Editora> Editoras = service.buscarEditoras(pesquisa);		
//		return ResponseEntity.ok().body(Editoras);
//	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public ResponseEntity<ItemEditoraLivro> salvar(@RequestBody ItemVinculoDTO dto){
		ItemEditoraLivro vinculo = new ItemEditoraLivro();
		vinculo = service.salvar(dto);
		return ResponseEntity.ok().body(vinculo);
		
	}
		
	@RequestMapping(value="/alterar", method=RequestMethod.PUT)
	public ResponseEntity<List<ItemUpdateDTO>> atualizar(@RequestBody List<ItemUpdateDTO> objDTO) throws Exception {
		if(objDTO.isEmpty()) {
			throw new Exception("Arquivo invalido");
		}
		service.update(objDTO);
		return new ResponseEntity<>(objDTO, HttpStatus.OK);
		
	}
	
}
