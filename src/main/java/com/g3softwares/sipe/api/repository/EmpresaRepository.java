package com.g3softwares.sipe.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3softwares.sipe.api.model.Empresa;
import com.g3softwares.sipe.api.model.Utilizador;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	List<Empresa> findByUtilizador(Utilizador utilizador);

}
