package com.g3softwares.sipe.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g3softwares.sipe.api.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	List<Cidade> findByNomeIgnoreCaseContaining(String nome);

}
