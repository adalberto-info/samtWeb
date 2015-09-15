
package br.com.samtweb.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 15/09/2015
 */
@Entity
@Table(name="paisVeiculo")
public class PaisVeiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_pais", nullable=false, length=10)
    private int id_pais;
    @Column(name="dc_descricao", nullable=false, length=40)
    private String dc_descricao; 

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getDc_descricao() {
        return dc_descricao;
    }

    public void setDc_descricao(String dc_descricao) {
        this.dc_descricao = dc_descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id_pais;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PaisVeiculo other = (PaisVeiculo) obj;
        if (this.id_pais != other.id_pais) {
            return false;
        }
        return true;
    }
    
    
    
}
