package br.backend.api.controller;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.backend.api.entity.Livro;
import br.backend.api.service.LivroService;
import br.backend.api.storage.Disco;

@RestController
@RequestMapping(value="/livro")
public class LivroController {
	
	@Autowired
	private LivroService service;
	
	@Autowired
	private Disco disco; 
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Livro>> listar(){
		List<Livro> livros = service.listar();
		return ResponseEntity.ok().body(livros);
	}
	
	@RequestMapping(value="/{titulo}",method=RequestMethod.GET)
	public ResponseEntity<List<Livro>> buscarLivro(@PathVariable("titulo") String titulo){
		List<Livro> livros = service.buscarLivros(titulo);
		
		return ResponseEntity.ok().body(livros);
	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public ResponseEntity<Livro> salvar(@RequestBody Livro livro){
		Livro l = new Livro();
		System.out.println(livro.getFoto());
		
		return ResponseEntity.ok().body(l);
		
	}
	
	@RequestMapping(value="/{foto}",method=RequestMethod.POST)
	public void upload(@RequestParam("foto") MultipartFile foto) {	
		String nome = String.valueOf(new Random().nextLong());		
		System.out.println(foto);		
		disco.salvarFoto(foto);
		
	}
	
	

}
