package com.g3softwares.sipe.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.g3softwares.sipe.api.model.Empresa;
import com.g3softwares.sipe.api.model.EmpresaUsuario;
import com.g3softwares.sipe.api.model.Liberacao;
import com.g3softwares.sipe.api.model.Modulo;
import com.g3softwares.sipe.api.model.Usuario;
import com.g3softwares.sipe.api.model.Utilizador;
import com.g3softwares.sipe.api.repository.EmpresaRepository;
import com.g3softwares.sipe.api.repository.LiberacaoRepository;
import com.g3softwares.sipe.api.repository.UsuarioUtilizadorRepository;

@Service
public class LiberacaoService {

	@Autowired
	private LiberacaoRepository liberacaoRepository;

	@Autowired
	private UsuarioUtilizadorRepository usuarioUtilizadorRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	public List<Liberacao> buscarPorUsuario(Long usuario) {

		List<Liberacao> liberacoes = this.liberacaoRepository.findAllByUsuario(usuario);
		if (liberacoes == null || liberacoes.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return liberacoes;
	}

	public List<EmpresaUsuario> carregarLiberacoesDisponiveis(Long usuario) {

		Usuario usuarioEncontrado = usuarioUtilizadorRepository.findOne(usuario);
		if (usuarioEncontrado == null) {
			throw new EmptyResultDataAccessException(1);
		}

		List<Empresa> empresasEncontradas = carregarEmpresas(usuarioEncontrado.getUtilizador());
		List<Modulo> modulosUtilizador = usuarioEncontrado.getUtilizador().getModulos();

		long codigo = 1;
		List<EmpresaUsuario> empresasUsuario = new ArrayList<>();
		for (Empresa empresa : empresasEncontradas) {
			for (Modulo modulo : modulosUtilizador) {
				empresasUsuario.add(new EmpresaUsuario(codigo, empresa, modulo));
				codigo++;
			}
		}
		if (empresasUsuario.isEmpty()) {
			throw new EmptyResultDataAccessException(
					"Nenhuma permissão relacionada às empresas cadastradas foi encontada.", 1);
		}
		return empresasUsuario;
	}

	private List<Empresa> carregarEmpresas(Utilizador utilizador) {
		
		List<Empresa> empresasEncontradas = empresaRepository.findByUtilizador(utilizador);
		if (empresasEncontradas == null || empresasEncontradas.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return empresasEncontradas;
	}

}
