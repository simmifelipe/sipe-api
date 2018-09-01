package com.g3softwares.sipe.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.g3softwares.sipe.api.model.TipoParticipante;
import com.g3softwares.sipe.api.repository.TipoParticipanteRepository;

@Service
public class TipoParticipanteService {

	@Autowired
	private TipoParticipanteRepository tipoParticipanteRepository;

	public TipoParticipante atualizar(Long codigo, TipoParticipante tipoParticipante) {

		TipoParticipante tipoParticipanteSalvo = buscarTipoParticipantePeloCodigo(codigo);

		BeanUtils.copyProperties(tipoParticipante, tipoParticipanteSalvo, "codigo");
		return this.tipoParticipanteRepository.save(tipoParticipanteSalvo);
	}

	public TipoParticipante buscarTipoParticipantePeloCodigo(Long codigo) {
		TipoParticipante tipoParticipanteSalvo = tipoParticipanteRepository.findOne(codigo);
		if (tipoParticipanteSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return tipoParticipanteSalvo;
	}
}
