package com.da.analitics.repositories;

import com.da.analitics.domain.Municipio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer>{
    
}
