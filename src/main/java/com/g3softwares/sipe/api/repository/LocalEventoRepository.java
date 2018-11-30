package com.g3softwares.sipe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3softwares.sipe.api.model.LocalEvento;

@Repository
public interface LocalEventoRepository extends JpaRepository<LocalEvento, Long> {

}
