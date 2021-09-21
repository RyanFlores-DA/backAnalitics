package com.da.analitics.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.da.analitics.domain.Municipio;

public class MunicipioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull(message = "O campo nome é obrigatório")
    @Size(min = 4, max = 40, message = "Tamanho minímo é 4 caracteres e máximo 40 caracteres")
    private String name;
    private Integer pibDez;

    public MunicipioDTO() {
        super();
    }

    public MunicipioDTO(Municipio obj) {
        super();
        this.id = obj.getId();
        this.name = obj.getNome();
        this.pibDez = obj.getPibDez();
    }

    public Integer getPibDez() {
        return pibDez;
    }

    public void setPibDez(Integer pibDez) {
        this.pibDez = pibDez;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
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
        MunicipioDTO other = (MunicipioDTO) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
