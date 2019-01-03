package com.g3softwares.sipe.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.g3softwares.sipe.api.model.Liberacao;
import com.g3softwares.sipe.api.model.Usuario;
import com.g3softwares.sipe.api.repository.EmpresaModuloRepository;
import com.g3softwares.sipe.api.repository.LiberacaoRepository;
import com.g3softwares.sipe.api.repository.UsuarioUtilizadorRepository;
import com.g3softwares.sipe.api.security.util.EncodePassword;

@Service
public class UsuarioUtilizadorService {

	@Autowired
	private UsuarioUtilizadorRepository usuarioUtilizadorRepository;

	@Autowired
	private LiberacaoRepository liberacaoRepository;

	@Autowired
	private EmpresaModuloRepository empresaModuloRepository;

	public Usuario atualizar(Long codigo, Usuario usuarioUtilizador) {

		Usuario usuarioUtilizadorSalvo = buscarUsuarioUtilizadorPeloCodigo(codigo);
		BeanUtils.copyProperties(usuarioUtilizador, usuarioUtilizadorSalvo, "codigo");
		return usuarioUtilizadorRepository.save(usuarioUtilizadorSalvo);
	}

	public Usuario buscarUsuarioUtilizadorPeloCodigo(Long codigo) {

		Usuario usuarioUtilizadorSalvo = usuarioUtilizadorRepository.findOne(codigo);
		if (usuarioUtilizadorSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return usuarioUtilizadorSalvo;
	}

	public Usuario salvar(Usuario usuario) {

		for (Liberacao liberacao : usuario.getLiberacoes()) {

			liberacao.getLiberacaoPK()
					.setEmpresaModulo(empresaModuloRepository.findByEmpresaAndModulo(
							liberacao.getLiberacaoPK().getEmpresaModulo().getEmpresa(),
							liberacao.getLiberacaoPK().getEmpresaModulo().getModulo()));
			liberacaoRepository.save(liberacao);
		}

		usuario.setSenha(new EncodePassword().encode(usuario.getSenha()));
		return this.usuarioUtilizadorRepository.save(usuario);

	}
}
