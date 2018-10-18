package com.g3softwares.sipe.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3softwares.sipe.api.model.Usuario;

@Repository
public interface UsuarioUtilizadorRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
}
