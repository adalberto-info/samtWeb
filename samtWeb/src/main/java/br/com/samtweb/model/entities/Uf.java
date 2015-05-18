
package br.com.samtweb.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.ForeignKey;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 18/05/2015
 */
public class Uf implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="id_uf", nullable=false)
    private Integer id_uf;
    @Column(name="dc_sigla", nullable=false)
    private String dc_sigla;
    @Column(name="dc_descricao", nullable=false)
    private String dc_descricao;

    @OneToMany
    @ForeignKey(name="fk_uf")
    private List<Municipio> municipio;
    
    public Uf() {
    }
    
    public Integer getId_uf() {
        return id_uf;
    }

    public void setId_uf(Integer id_uf) {
        this.id_uf = id_uf;
    }

    public String getDc_sigla() {
        return dc_sigla;
    }

    public void setDc_sigla(String dc_sigla) {
        this.dc_sigla = dc_sigla;
    }

    public String getDc_descricao() {
        return dc_descricao;
    }

    public void setDc_descricao(String dc_descricao) {
        this.dc_descricao = dc_descricao;
    }

    public List<Municipio> getMunicipio() {
        return municipio;
    }

    public void setMunicipio(List<Municipio> municipio) {
        this.municipio = municipio;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.id_uf != null ? this.id_uf.hashCode() : 0);
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
        final Uf other = (Uf) obj;
        if (this.id_uf != other.id_uf && (this.id_uf == null || !this.id_uf.equals(other.id_uf))) {
            return false;
        }
        return true;
    }

    
    
    
}
