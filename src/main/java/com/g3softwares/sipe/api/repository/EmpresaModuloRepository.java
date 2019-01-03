package com.g3softwares.sipe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g3softwares.sipe.api.model.Empresa;
import com.g3softwares.sipe.api.model.EmpresaModulo;
import com.g3softwares.sipe.api.model.Modulo;

public interface EmpresaModuloRepository extends JpaRepository<EmpresaModulo, Long> {

	EmpresaModulo findByEmpresaAndModulo(Empresa empresa, Modulo modulo);
}
