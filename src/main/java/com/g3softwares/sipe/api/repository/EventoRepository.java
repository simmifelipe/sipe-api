package com.g3softwares.sipe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3softwares.sipe.api.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

}
