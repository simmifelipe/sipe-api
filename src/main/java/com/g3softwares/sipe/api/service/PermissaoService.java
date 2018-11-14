package com.g3softwares.sipe.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.g3softwares.sipe.api.model.Permissao;
import com.g3softwares.sipe.api.repository.PermissaoRepository;

@Service
public class PermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;

	public Permissao atualizar(Long codigo, Permissao permissao) {

		Permissao permissaoSalva = buscarPermissaoPeloCodigo(codigo);

		BeanUtils.copyProperties(permissao, permissaoSalva, "codigo");
		return permissaoRepository.save(permissaoSalva);
	}

	public Permissao buscarPermissaoPeloCodigo(Long codigo) {
		Permissao permissaoSalva = permissaoRepository.findOne(codigo);
		if (permissaoSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return permissaoSalva;
	}

}
