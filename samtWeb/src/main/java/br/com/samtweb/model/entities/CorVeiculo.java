
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
@Table(name="corVeiculo")
public class CorVeiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="id_cor")
    private Integer id_cor;
    @Column(name="dc_descricao")
    private String dc_descricao;

    public Integer getId_cor() {
        return id_cor;
    }

    public void setId_cor(Integer id_cor) {
        this.id_cor = id_cor;
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
        hash = 97 * hash + (this.id_cor != null ? this.id_cor.hashCode() : 0);
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
        final CorVeiculo other = (CorVeiculo) obj;
        return true;
    }
   
    
}
