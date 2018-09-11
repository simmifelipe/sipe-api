package com.g3softwares.sipe.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.g3softwares.sipe.api.model.TipoItemCheckList;
import com.g3softwares.sipe.api.repository.TipoItemCheckListRepository;

@Service
public class TipoItemCheckListService {

	@Autowired
	private TipoItemCheckListRepository tipoItemCheckListRepository;

	public TipoItemCheckList atualizar(Long codigo, TipoItemCheckList tipoItemCheckList) {

		TipoItemCheckList tipoItemCheckListSalvo = buscarTipoItemCheckListPeloCodigo(codigo);

		BeanUtils.copyProperties(tipoItemCheckList, tipoItemCheckListSalvo, "codigo");
		return tipoItemCheckListRepository.save(tipoItemCheckListSalvo);
	}

	public TipoItemCheckList buscarTipoItemCheckListPeloCodigo(Long codigo) {
		TipoItemCheckList tipoItemCheckListSalvo = tipoItemCheckListRepository.findOne(codigo);
		if (tipoItemCheckListSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return tipoItemCheckListSalvo;
	}
}
