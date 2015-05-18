
package br.com.samtweb.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 18/05/2015
 */
@Entity
@Table(name="municipio")

public class Municipio implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="id_municipio", nullable=false)
    private Integer id_municipio;
    @Column(name="dc_municipio", length= 40, nullable=false)
    private String dc_municipio; 
    
    @OneToMany
    @ForeignKey(name="fk_municipio")
    private List<Filial> filial;

    @ManyToOne(optional=false)
    @ForeignKey(name="fk_uf")
    private Municipio municipio;
    
    public Municipio() {
    }
    
    public Integer getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Integer id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getDc_municipio() {
        return dc_municipio;
    }

    public void setDc_municipio(String dc_municipio) {
        this.dc_municipio = dc_municipio;
    }

    public List<Filial> getFilial() {
        return filial;
    }

    public void setFilial(List<Filial> filial) {
        this.filial = filial;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.id_municipio != null ? this.id_municipio.hashCode() : 0);
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
        final Municipio other = (Municipio) obj;
        if (this.id_municipio != other.id_municipio && (this.id_municipio == null || !this.id_municipio.equals(other.id_municipio))) {
            return false;
        }
        return true;
    }

    
    
}
