package com.g3softwares.sipe.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.g3softwares.sipe.api.model.Liberacao;

public interface LiberacaoRepository extends JpaRepository<Liberacao, Long> {

	@Query("SELECT l FROM Liberacao l WHERE l.liberacaoPK.usuario.codigo = ?1")
	public List<Liberacao> findAllByUsuario(Long usuario);

}
