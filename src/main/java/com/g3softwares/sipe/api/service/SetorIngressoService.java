package com.g3softwares.sipe.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.g3softwares.sipe.api.model.SetorIngresso;
import com.g3softwares.sipe.api.repository.SetorIngressoRepository;

@Service
public class SetorIngressoService {

	@Autowired
	private SetorIngressoRepository setorIngressoRepository;

	public SetorIngresso atualizar(Long codigo, SetorIngresso setorIngresso) {

		SetorIngresso setorIngressoSalvo = buscarSetorIngressoPeloCodigo(codigo);
		BeanUtils.copyProperties(setorIngresso, setorIngressoSalvo, "codigo");
		return setorIngressoRepository.save(setorIngressoSalvo);
	}
	
	public SetorIngresso salvar(SetorIngresso setorIngresso) {
		SetorIngresso setorIngressoSalvo = this.setorIngressoRepository.save(setorIngresso);
		return setorIngressoSalvo;
	}
	

	public SetorIngresso buscarSetorIngressoPeloCodigo(Long codigo) {

		SetorIngresso setorIngressoSalvo = setorIngressoRepository.findOne(codigo);
		if (setorIngressoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return setorIngressoSalvo;
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {

		SetorIngresso setorIngressoSalvo = buscarSetorIngressoPeloCodigo(codigo);
		setorIngressoSalvo.setAtivo(ativo);
		setorIngressoRepository.save(setorIngressoSalvo);
	}
}

