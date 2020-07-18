package br.backend.api.livro.editora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/editora")
public class EditoraResource {
	
	@Autowired
	EditoraService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Editora>> listar(){
		List<Editora> Editoras = service.listar();
		return ResponseEntity.ok().body(Editoras);
	}
	
//	@RequestMapping(value="/{pesquisa}",method=RequestMethod.GET)
//	public ResponseEntity<List<Editora>> buscarEditora(@PathVariable("pesquisa") String pesquisa){
//		List<Editora> Editoras = service.buscarEditoras(pesquisa);		
//		return ResponseEntity.ok().body(Editoras);
//	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public ResponseEntity<Editora> salvar(@RequestBody Editora Editora){
		Editora l = new Editora();
		l = service.salvar(Editora);
		return ResponseEntity.ok().body(l);
		
	}

}
