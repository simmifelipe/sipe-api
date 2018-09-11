package com.g3softwares.sipe.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.g3softwares.sipe.api.model.ItemCheckList;
import com.g3softwares.sipe.api.repository.ItemCheckListRepository;

@Service
public class ItemCheckListService {

	@Autowired
	private ItemCheckListRepository itemCheckListRepository;

	public ItemCheckList atualizar(Long codigo, ItemCheckList itemCheckList) {

		ItemCheckList itemCheckListSalvo = buscarItemCheckListPeloCodigo(codigo);
		BeanUtils.copyProperties(itemCheckList, itemCheckListSalvo, "codigo");
		return itemCheckListRepository.save(itemCheckListSalvo);
	}

	public ItemCheckList buscarItemCheckListPeloCodigo(Long codigo) {

		ItemCheckList itemCheckListSalvo = itemCheckListRepository.findOne(codigo);
		if (itemCheckListSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return itemCheckListSalvo;
	}
}
