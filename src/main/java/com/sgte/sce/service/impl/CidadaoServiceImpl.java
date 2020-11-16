package com.sgte.sce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgte.sce.models.Cidadao;
import com.sgte.sce.repository.CidadaoRepository;
import com.sgte.sce.service.CidadaoService;

@Service
public class CidadaoServiceImpl implements CidadaoService{

	@Autowired
	CidadaoRepository cidadaoRepository;

	@Override
	public Cidadao buscarPorTurma(String turma) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
