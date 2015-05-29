
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
    private Integer id_usuario;
    @Column(name="dc_nomeUsuario", nullable=false, length=40)
    private String dc_nomeUsuario;
    @Column(name="dc_senha", nullable=false, length=12)
    private String dc_senha;

    @ManyToOne(optional=false)
    @ForeignKey(name = "FilialUsuario")
    @JoinColumn(name = "fk_filial", referencedColumnName="id_filial")
    private Filial filial;
    
    
    public Usuario() {
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
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

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.id_usuario != null ? this.id_usuario.hashCode() : 0);
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
        if (this.id_usuario != other.id_usuario && (this.id_usuario == null || !this.id_usuario.equals(other.id_usuario))) {
            return false;
        }
        return true;
    }

    
}
