package com.g3softwares.sipe.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.g3softwares.sipe.api.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

	@Query("SELECT p FROM Permissao p WHERE p.modulo.codigo = ?1 and p.nivel >= ?2")
	List<Permissao> findPermissoesByModuloAndNivel(Long modulo, Integer nivel);

}
