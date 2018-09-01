package com.g3softwares.sipe.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.g3softwares.sipe.api.model.Utilizador;
import com.g3softwares.sipe.api.repository.UtilizadorRepository;

@Service
public class UtilizadorService {

	@Autowired
	private UtilizadorRepository utilizadorRepository;

	public Utilizador atualizar(Long codigo, Utilizador utilizador) {

		Utilizador utilizadorSalvo = buscarUtilizadorPeloCodigo(codigo);

		BeanUtils.copyProperties(utilizador, utilizadorSalvo, "codigo");
		return utilizadorRepository.save(utilizadorSalvo);
	}

	public Utilizador buscarUtilizadorPeloCodigo(Long codigo) {
		Utilizador utilizadorSalvo = utilizadorRepository.findOne(codigo);
		if (utilizadorSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return utilizadorSalvo;
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {

		Utilizador utilizadorSalvo = buscarUtilizadorPeloCodigo(codigo);
		utilizadorSalvo.setAtivo(ativo);
		utilizadorRepository.save(utilizadorSalvo);
	}
}
