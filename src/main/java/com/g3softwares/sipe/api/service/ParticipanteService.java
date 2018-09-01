package com.g3softwares.sipe.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.g3softwares.sipe.api.model.Participante;
import com.g3softwares.sipe.api.repository.ParticipanteRepository;

@Service
public class ParticipanteService {

	@Autowired
	private ParticipanteRepository participanteRepository;

	public Participante atualizar(Long codigo, Participante utilizador) {

		Participante participanteSalvo = buscarParticipantePeloCodigo(codigo);

		BeanUtils.copyProperties(utilizador, participanteSalvo, "codigo");
		return participanteRepository.save(participanteSalvo);
	}

	public Participante buscarParticipantePeloCodigo(Long codigo) {
		Participante participanteSalvo = participanteRepository.findOne(codigo);
		if (participanteSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return participanteSalvo;
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {

		Participante participanteSalvo = buscarParticipantePeloCodigo(codigo);
		participanteSalvo.setAtivo(ativo);
		participanteRepository.save(participanteSalvo);
	}
}
