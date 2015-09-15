
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
@Table(name="tipoVeiculo")
public class TipoVeiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_tipo", nullable=false, length=3)
    private int id_tipo;
    @Column(name="dc_descricao", nullable=false, length=20)
    private String dc_descricao;

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
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
        hash = 19 * hash + this.id_tipo;
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
        final TipoVeiculo other = (TipoVeiculo) obj;
        if (this.id_tipo != other.id_tipo) {
            return false;
        }
        return true;
    }




}
