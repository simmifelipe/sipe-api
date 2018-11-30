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
public class ModuloService {

	@Autowired
	private ModuloRepository moduloRepository;

	@Autowired
	private EmpresaModuloRepository empresaModuloRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;

	public Modulo atualizar(Long codigo, Modulo modulo) {

		Modulo moduloSalvo = buscarModuloPeloCodigo(codigo);
		BeanUtils.copyProperties(modulo, moduloSalvo, "codigo");
		moduloSalvo = moduloRepository.save(moduloSalvo);

		criarEmpresaModulo(moduloSalvo);

		return moduloSalvo;
	}

	public Modulo salvar(Modulo modulo) {
		Modulo moduloSalvo = this.moduloRepository.save(modulo);
		criarEmpresaModulo(moduloSalvo);
		return moduloSalvo;
	}

	public Modulo buscarModuloPeloCodigo(Long codigo) {

		Modulo moduloSalvo = moduloRepository.findOne(codigo);
		if (moduloSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return moduloSalvo;
	}

	private void criarEmpresaModulo(Modulo moduloSalvo) {

		List<EmpresaModulo> empresaModuloExistentes = this.empresaModuloRepository.findAll();
		List<Empresa> empresasExistentes = this.empresaRepository.findAll();

		EmpresaModulo temp = null;
		for (Empresa empresa : empresasExistentes) {
			temp = new EmpresaModulo();
			temp.setEmpresa(empresa);
			temp.setModulo(moduloSalvo);
			if (!empresaModuloExistentes.contains(temp)) {
				this.empresaModuloRepository.save(temp);
			}
		}
	}
}
