package com.g3softwares.sipe.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.g3softwares.sipe.api.model.Empresa;
import com.g3softwares.sipe.api.model.EmpresaModulo;
import com.g3softwares.sipe.api.model.Modulo;
import com.g3softwares.sipe.api.repository.EmpresaModuloRepository;
import com.g3softwares.sipe.api.repository.EmpresaRepository;
import com.g3softwares.sipe.api.repository.ModuloRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private EmpresaModuloRepository empresaModuloRepository;

	@Autowired
	private ModuloRepository moduloRepository;

	public Empresa atualizar(Long codigo, Empresa empresa) {

		Empresa empresaSalva = buscarEmpresaPeloCodigo(codigo);

		BeanUtils.copyProperties(empresa, empresaSalva, "codigo");
		empresaSalva = empresaRepository.save(empresaSalva);

		criarEmpresaModulo(empresaSalva);

		return empresaSalva;
	}

	public Empresa salvar(Empresa empresa) {
		
		Empresa empresaSalva = this.empresaRepository.save(empresa);
		criarEmpresaModulo(empresaSalva);
		return empresaSalva;
	}

	public Empresa buscarEmpresaPeloCodigo(Long codigo) {
		Empresa empresaSalva = empresaRepository.findOne(codigo);
		if (empresaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return empresaSalva;
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {

		Empresa empresaSalva = buscarEmpresaPeloCodigo(codigo);
		empresaSalva.setAtivo(ativo);
		empresaRepository.save(empresaSalva);
	}

	private void criarEmpresaModulo(Empresa empresaSalva) {
		List<EmpresaModulo> empresaModuloExistentes = this.empresaModuloRepository.findAll();
		List<Modulo> modulosExistentes = this.moduloRepository.findAll();

		EmpresaModulo temp = null;
		for (Modulo modulo : modulosExistentes) {
			temp = new EmpresaModulo();
			temp.setEmpresa(empresaSalva);
			temp.setModulo(modulo);
			if (!empresaModuloExistentes.contains(temp)) {
				this.empresaModuloRepository.save(temp);
			}
		}
	}

}
