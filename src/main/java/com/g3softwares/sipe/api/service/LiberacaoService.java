package com.g3softwares.sipe.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.g3softwares.sipe.api.model.Liberacao;
import com.g3softwares.sipe.api.repository.LiberacaoRepository;

@Service
public class LiberacaoService {

	@Autowired
	private LiberacaoRepository liberacaoRepository;

	public List<Liberacao> buscarPorUsuario(Long usuario) {

		List<Liberacao> liberacoes = this.liberacaoRepository.findAllByUsuario(usuario);
		if (liberacoes == null || liberacoes.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return liberacoes;
	}

}
