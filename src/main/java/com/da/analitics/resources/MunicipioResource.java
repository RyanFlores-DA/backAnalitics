package com.da.analitics.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.da.analitics.domain.Municipio;
import com.da.analitics.dtos.MunicipioDTO;
import com.da.analitics.service.MunicipioService;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/municipio")
public class MunicipioResource {

    @Autowired
    private MunicipioService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Municipio> findById(@PathVariable Integer id) {
        Municipio obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<MunicipioDTO>> findAll() {
        List<Municipio> list = service.findAll();
        List<MunicipioDTO> listDTO = list.stream().map(obj -> new MunicipioDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Municipio> create(@RequestBody Municipio obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MunicipioDTO> update(@PathVariable Integer id, @RequestBody MunicipioDTO objDto) {
        Municipio newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new MunicipioDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
