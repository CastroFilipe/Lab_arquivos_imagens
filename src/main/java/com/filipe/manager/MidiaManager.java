package com.filipe.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filipe.model.Midia;
import com.filipe.repository.MidiaRepository;

@Service
public class MidiaManager {
	
	@Autowired
	private MidiaRepository midiaRepository;
	
	@Transactional(readOnly = true)
	public Midia buscarPorId(Long id) {
		return midiaRepository.findById(id).get();
	}
	
	@Transactional
	public Midia inserir(Midia midia) {
		return midiaRepository.save(midia);
	}
	
}
