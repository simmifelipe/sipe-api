package com.g3softwares.sipe.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.g3softwares.sipe.api.model.Tarefa;
import com.g3softwares.sipe.api.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;

	public Tarefa atualizar(Long codigo, Tarefa tarefa) {

		Tarefa tarefaSalva = buscarTarefaPeloCodigo(codigo);

		BeanUtils.copyProperties(tarefa, tarefaSalva, "codigo");
		return tarefaRepository.save(tarefaSalva);
	}

	public Tarefa buscarTarefaPeloCodigo(Long codigo) {
		Tarefa tarefaSalva = tarefaRepository.findOne(codigo);
		if (tarefaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return tarefaSalva;
	}
}
