
package br.com.samtweb.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 15/05/2015
 */

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="id_usuario", nullable=false)
    private Integer idUsuario;
    @Column(name="fk_filial", nullable=false)
    private Integer fk_filial;
    @Column(name="dc_nomeUsuario", nullable=false, length=40)
    private String dc_nomeUsuario;
    @Column(name="dc_senha", nullable=false, length=12)
    private String dc_senha;

    @ManyToOne(optional=false)
    @ForeignKey(name = "FilialUsuario")
    @JoinColumn(name = "id_filial", referencedColumnName="id_filial")
    private Filial filial;
    
    
    public Usuario() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getFk_filial() {
        return fk_filial;
    }

    public void setFk_filial(Integer fk_filial) {
        this.fk_filial = fk_filial;
    }

    public String getDc_nomeUsuario() {
        return dc_nomeUsuario;
    }

    public void setDc_nomeUsuario(String dc_nomeUsuario) {
        this.dc_nomeUsuario = dc_nomeUsuario;
    }

    public String getDc_senha() {
        return dc_senha;
    }

    public void setDc_senha(String dc_senha) {
        this.dc_senha = dc_senha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.idUsuario != null ? this.idUsuario.hashCode() : 0);
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
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario && (this.idUsuario == null || !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    
}
