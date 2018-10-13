package com.g3softwares.sipe.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.g3softwares.sipe.api.model.UsuarioUtilizador;
import com.g3softwares.sipe.api.repository.UsuarioUtilizadorRepository;
import com.g3softwares.sipe.api.security.util.EncodePassword;

@Service
public class UsuarioUtilizadorService {

	@Autowired
	private UsuarioUtilizadorRepository usuarioUtilizadorRepository;

	public UsuarioUtilizador atualizar(Long codigo, UsuarioUtilizador usuarioUtilizador) {

		UsuarioUtilizador usuarioUtilizadorSalvo = buscarUsuarioUtilizadorPeloCodigo(codigo);
		BeanUtils.copyProperties(usuarioUtilizador, usuarioUtilizadorSalvo, "codigo");
		return usuarioUtilizadorRepository.save(usuarioUtilizadorSalvo);
	}

	public UsuarioUtilizador buscarUsuarioUtilizadorPeloCodigo(Long codigo) {

		UsuarioUtilizador usuarioUtilizadorSalvo = usuarioUtilizadorRepository.findOne(codigo);
		if (usuarioUtilizadorSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return usuarioUtilizadorSalvo;
	}
	
	public UsuarioUtilizador salvar(UsuarioUtilizador usuarioUtilizador) {
		
		usuarioUtilizador.setSenha(new EncodePassword().encode(usuarioUtilizador.getSenha()));
		return this.usuarioUtilizadorRepository.save(usuarioUtilizador);
		
	}
}
