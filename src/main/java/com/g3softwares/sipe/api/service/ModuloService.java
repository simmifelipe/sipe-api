package com.g3softwares.sipe.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.g3softwares.sipe.api.model.Modulo;
import com.g3softwares.sipe.api.repository.ModuloRepository;

@Service
public class ModuloService {

	@Autowired
	private ModuloRepository moduloRepository;

	public Modulo atualizar(Long codigo, Modulo modulo) {

		Modulo moduloSalvo = buscarModuloPeloCodigo(codigo);
		BeanUtils.copyProperties(modulo, moduloSalvo, "codigo");
		return moduloRepository.save(moduloSalvo);
	}

	public Modulo buscarModuloPeloCodigo(Long codigo) {

		Modulo moduloSalvo = moduloRepository.findOne(codigo);
		if (moduloSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return moduloSalvo;
	}
}
