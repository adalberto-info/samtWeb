
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
@Table(name="status")
public class Status implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_status", nullable=false, length=2)
    private int id_status; 
    @Column(name="dc_descricao", nullable=false, length=40)
    private String dc_descricao;

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
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
        hash = 31 * hash + this.id_status;
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
        final Status other = (Status) obj;
        if (this.id_status != other.id_status) {
            return false;
        }
        return true;
    }
    
    
    
}
