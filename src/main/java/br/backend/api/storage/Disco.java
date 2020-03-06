package br.backend.api.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Disco {

	@Value("${storage.disco.raiz}")
	private String raiz;
	
	@Value("${storage.disco.diretorio}")
	private String diretorioFotos;
	
	@Autowired
	private ServletContext context;
	
	public void salvarFoto(MultipartFile foto) {
		this.salvar(this.diretorioFotos, foto);
	}
	
	public void salvar(String diretorio, MultipartFile arquivo) {
		String realPath = "C:/Users/Evalton/Documents/workspace-spring-tool-suite-4-4.4.2.RELEASE/estudo_api/src/main/resources/livro/fotos";
		Path diretorioPath = Paths.get(realPath);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());
		
		
		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());
		}catch(IOException e) {
			throw new RuntimeException("Erro ao tentar salvar arquivo");
		}
		
	}
	
}
