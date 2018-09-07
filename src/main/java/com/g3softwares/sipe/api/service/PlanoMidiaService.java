package com.g3softwares.sipe.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.g3softwares.sipe.api.model.PlanoMidia;
import com.g3softwares.sipe.api.repository.PlanoMidiaRepository;

@Service
public class PlanoMidiaService {

	@Autowired
	private PlanoMidiaRepository planoMidiaRepository;

	public PlanoMidia atualizar(Long codigo, PlanoMidia planoMidia) {

		PlanoMidia planoMidiaSalvo = buscarPlanoMidiaPeloCodigo(codigo);
		BeanUtils.copyProperties(planoMidia, planoMidiaSalvo, "codigo");
		return planoMidiaRepository.save(planoMidiaSalvo);
	}

	public PlanoMidia buscarPlanoMidiaPeloCodigo(Long codigo) {

		PlanoMidia planoMidiaSalvo = planoMidiaRepository.findOne(codigo);
		if (planoMidiaSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return planoMidiaSalvo;
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {

		PlanoMidia planoMidiaSalvo = buscarPlanoMidiaPeloCodigo(codigo);
		planoMidiaSalvo.setAtivo(ativo);
		planoMidiaRepository.save(planoMidiaSalvo);
	}
}
