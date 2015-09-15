
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
@Table(name="tipoInconsistencia")
public class TipoInconsistencia implements Serializable{

    private static final long SerialVersionUID = 1L;
    
    @Id
    @Column(name="id_tipoInconsistencia", nullable=false, length=4)
    private int id_tipoInconsistencia;
    @Column(name="dc_descricao", nullable=false, length=80)
    private String dc_descricao; 
    @Column(name="lg_interno", nullable=false, length=1)
    private int lg_interno;
    @Column(name="lg_tecnico", nullable=false, length=1)
    private int lg_tecnino; 

    public int getId_tipoInconsistencia() {
        return id_tipoInconsistencia;
    }

    public void setId_tipoInconsistencia(int id_tipoInconsistencia) {
        this.id_tipoInconsistencia = id_tipoInconsistencia;
    }

    public String getDc_descricao() {
        return dc_descricao;
    }

    public void setDc_descricao(String dc_descricao) {
        this.dc_descricao = dc_descricao;
    }

    public int getLg_interno() {
        return lg_interno;
    }

    public void setLg_interno(int lg_interno) {
        this.lg_interno = lg_interno;
    }

    public int getLg_tecnino() {
        return lg_tecnino;
    }

    public void setLg_tecnino(int lg_tecnino) {
        this.lg_tecnino = lg_tecnino;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id_tipoInconsistencia;
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
        final TipoInconsistencia other = (TipoInconsistencia) obj;
        if (this.id_tipoInconsistencia != other.id_tipoInconsistencia) {
            return false;
        }
        return true;
    }

    
    
    
}
