package com.g3softwares.sipe.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.g3softwares.sipe.api.model.Evento;
import com.g3softwares.sipe.api.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoRepository;

	public Evento atualizar(Long codigo, Evento evento) {

		Evento eventoSalvo = buscarEventoPeloCodigo(codigo);
		BeanUtils.copyProperties(evento, eventoSalvo, "codigo");
		return eventoRepository.save(eventoSalvo);
	}

	public Evento buscarEventoPeloCodigo(Long codigo) {

		Evento eventoSalvo = eventoRepository.findOne(codigo);
		if (eventoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return eventoSalvo;
	}
}
