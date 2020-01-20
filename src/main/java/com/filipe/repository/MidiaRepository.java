package com.filipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filipe.model.Midia;

@Repository
public interface MidiaRepository extends JpaRepository<Midia, Long> {

}
