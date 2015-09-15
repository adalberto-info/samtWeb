
package br.com.samtweb.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 11/09/2015
 */

@Entity
@Table(name="especieVeiculo")
public class EspecieVeiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="id_especie", nullable=false, length=3)
    private int id_especie;
    @Column(name="dc_descricao", nullable=false, length=15)
    private String dc_descricao;

    public int getId_especie() {
        return id_especie;
    }

    public void setId_especie(int id_especie) {
        this.id_especie = id_especie;
    }

    public String getDc_descricao() {
        return dc_descricao;
    }

    public void setDc_descricao(String dc_descricao) {
        this.dc_descricao = dc_descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id_especie;
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
        final EspecieVeiculo other = (EspecieVeiculo) obj;
        if (this.id_especie != other.id_especie) {
            return false;
        }
        return true;
    }

    
    
}
