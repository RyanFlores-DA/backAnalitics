package com.da.analitics.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.analitics.domain.Municipio;
import com.da.analitics.dtos.MunicipioDTO;
import com.da.analitics.service.exceptions.ObjectNotFoundException;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;
import com.da.analitics.repositories.MunicipioRepository;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository repository;

    public Municipio findById(Integer id) {
        Optional<Municipio> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id + ", Tipo:" + Municipio.class.getName()));

    }

    public List<Municipio> findAll() {
        return repository.findAll();
    }

    public Municipio create(Municipio obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Municipio update(Integer id, MunicipioDTO objDTO) {
        Municipio obj = findById(id);
        obj.setNome(objDTO.getNome());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);

        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.da.analitics.service.exceptions.DataIntegretyViolationException("Municipio não pode ser deletado");
        }
    }
}
