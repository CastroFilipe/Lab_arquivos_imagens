package com.filipe.controller;

import java.io.IOException;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.filipe.manager.MidiaManager;
import com.filipe.model.Midia;

@RestController
@RequestMapping("/midias")
public class MidiaController {
	
	//private static String UPLOADED_FOLDER = "C://imagens";

	@Autowired
	private MidiaManager midiaManager;
	
	@GetMapping("/{id}")
	public ResponseEntity<Midia> buscarPorId(@PathVariable Long id){
		
		Midia midia = midiaManager.buscarPorId(id);
		
		return ResponseEntity.ok().body(midia);
	}
	
	@PostMapping
	public void Upload(@RequestParam("file") MultipartFile file) {
		Midia midia = new Midia();
		
		try {
			midia.setArquivoMidia(BlobProxy.generateProxy(file.getBytes()));
			
			//midia.setArquivoMidia(file.getBytes());
			midiaManager.inserir(midia);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("OK");
	}
}
