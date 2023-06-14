package com.starwars.planetas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.starwars.planetas.domain.planeta.Planeta;
import com.starwars.planetas.domain.planeta.PlanetaPostDTO;
import com.starwars.planetas.repository.PlanetaRepository;

import jakarta.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/planeta")
public class PlanetaController {

    @Autowired
    private PlanetaRepository repository;
    
    @PostMapping
    public ResponseEntity<Planeta> adicionar(@RequestBody @Valid PlanetaPostDTO planetaPostDTO, UriComponentsBuilder uriBuilder) {
        Planeta planeta = new Planeta();
        BeanUtils.copyProperties(planetaPostDTO, planeta);
        repository.save(planeta);

        var uri = uriBuilder.path("/planeta/{id}").buildAndExpand(planeta.getId()).toUri();
        
        return ResponseEntity.created(uri).body(planeta);
    }
    
}
