package com.da.analitics.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer pibDez;

    public Integer getPibDez() {
        return pibDez;
    }

    public void setPibDez(Integer pibDez) {
        this.pibDez = pibDez;
    }


    public Municipio() {
        super();
    }

    public Municipio(Integer id, String nome, Integer pibDez) {
        super();
        this.id = id;
        this.nome = nome;
        this.pibDez = pibDez;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Municipio other = (Municipio) obj;
        return Objects.equals(id, other.id);
    }

}
