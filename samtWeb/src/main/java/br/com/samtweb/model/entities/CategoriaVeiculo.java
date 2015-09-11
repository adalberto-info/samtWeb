
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
@Table(name="categoriaVeiculo")
public class CategoriaVeiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name="id_categoria", nullable=false)
    private Integer id_categoria;
    @Column(name="dc_descricao", nullable=false, length=30)
    private String dc_descricao;

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
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
        hash = 79 * hash + (this.id_categoria != null ? this.id_categoria.hashCode() : 0);
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
        final CategoriaVeiculo other = (CategoriaVeiculo) obj;
        return true;
    }
 
    
    
}
