
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
@Table(name="processo")
public class Processo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_processo", nullable=false, length=4)
    private int id_processo;
    @Column(name="dc_descricao", nullable=false, length=60)
    private String dc_descricao; 
    @Column(name="lg_ProcessoAutomatico", nullable=false, length=1)
    private int lg_processoAutomatico;
    @Column(name="lg_permiteEdicao", nullable=false, length=1)
    private int lg_permiteEdicao; 
    @Column(name="lg_contratoUsa", nullable=false, length=1)
    private int lg_contratoUsa; 

    public int getId_processo() {
        return id_processo;
    }

    public void setId_processo(int id_processo) {
        this.id_processo = id_processo;
    }

    public String getDc_descricao() {
        return dc_descricao;
    }

    public void setDc_descricao(String dc_descricao) {
        this.dc_descricao = dc_descricao;
    }

    public int getLg_processoAutomatico() {
        return lg_processoAutomatico;
    }

    public void setLg_processoAutomatico(int lg_processoAutomatico) {
        this.lg_processoAutomatico = lg_processoAutomatico;
    }

    public int getLg_permiteEdicao() {
        return lg_permiteEdicao;
    }

    public void setLg_permiteEdicao(int lg_permiteEdicao) {
        this.lg_permiteEdicao = lg_permiteEdicao;
    }

    public int getLg_contratoUsa() {
        return lg_contratoUsa;
    }

    public void setLg_contratoUsa(int lg_contratoUsa) {
        this.lg_contratoUsa = lg_contratoUsa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id_processo;
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
        final Processo other = (Processo) obj;
        if (this.id_processo != other.id_processo) {
            return false;
        }
        return true;
    }
    
    
}
