package com.g3softwares.sipe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3softwares.sipe.api.model.SetorIngresso;

@Repository
public interface SetorIngressoRepository extends JpaRepository<SetorIngresso, Long> {

}
