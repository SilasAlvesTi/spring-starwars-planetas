package com.starwars.planetas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starwars.planetas.domain.planeta.Planeta;

public interface PlanetaRepository extends JpaRepository<Planeta, Long>{
    
}