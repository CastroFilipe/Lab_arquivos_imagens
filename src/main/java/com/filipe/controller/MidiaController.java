package com.filipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.filipe.manager.MidiaManager;
import com.filipe.model.Midia;

@Controller
public class MidiaController {
	
	private static String UPLOADED_FOLDER = "C://imagens";

	@Autowired
	private MidiaManager midiaManager;
	
	@GetMapping({"/", "/home"})
	public String home() {
		return "home";
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Midia> buscarPorId(Long id){
		
		Midia midia = midiaManager.buscarPorId(id);
		
		return ResponseEntity.ok().body(midia);
	}
	
	@PostMapping()
	public String inserir(@RequestParam("file") MultipartFile file){
		
		
		
		return "";
		
	}
}
