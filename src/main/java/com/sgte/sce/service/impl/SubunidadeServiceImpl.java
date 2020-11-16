package com.sgte.sce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.sgte.sce.models.Subunidade;
import com.sgte.sce.repository.SubunidadeRepository;
import com.sgte.sce.service.SubunidadeService;

@Service
public class SubunidadeServiceImpl implements SubunidadeService{

	@Autowired
	SubunidadeRepository subunidadeRepository;

	@Override
	public List<Subunidade> listarPorOm(Long id) {
		return null;
	}

	
	
}
