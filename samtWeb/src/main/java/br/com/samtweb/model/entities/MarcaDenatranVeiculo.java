
package br.com.samtweb.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 15/09/2015
 */
@Entity
@Table(name="marcaDenatanVeiculo")
public class MarcaDenatranVeiculo {

    private static final long SerialVersionUID = 1L;
    
    @Id
    @Column(name="id_marcaDenatran", nullable=false, length=6)
    private int id_marcaDenatran;
    @Column(name="dc_descricao", nullable=false, length=35)
    private String dc_descricao;

    public int getId_marcaDenatran() {
        return id_marcaDenatran;
    }

    public void setId_marcaDenatran(int id_marcaDenatran) {
        this.id_marcaDenatran = id_marcaDenatran;
    }

    public String getDc_descricao() {
        return dc_descricao;
    }

    public void setDc_descricao(String dc_descricao) {
        this.dc_descricao = dc_descricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id_marcaDenatran;
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
        final MarcaDenatranVeiculo other = (MarcaDenatranVeiculo) obj;
        if (this.id_marcaDenatran != other.id_marcaDenatran) {
            return false;
        }
        return true;
    }



    
    
    
}
