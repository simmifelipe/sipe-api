package com.g3softwares.sipe.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3softwares.sipe.api.model.SetorIngresso;
import com.g3softwares.sipe.api.model.TipoIngresso;
import com.g3softwares.sipe.api.model.Utilizador;

@Repository
public interface TipoIngressoRepository extends JpaRepository<TipoIngresso, Long> {
	
	List<TipoIngresso> findByUtilizador(Utilizador utilizador);

}
