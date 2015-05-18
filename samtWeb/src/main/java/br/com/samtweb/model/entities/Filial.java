
package br.com.samtweb.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 15/05/2015
 */


@Entity
@Table(name="filial")
public class Filial implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="id_Filial", nullable=false)
    private Integer id_Filial;
    @Column(name="dc_nomeFilial", nullable=false, length=40)
    private String dc_nomeFilial;
    @Column(name="dc_endereco", nullable=false, length=40)
    private String dc_endereco;
    @Column(name="dc_enderecoNumero", nullable=false, length=15)
    private String dc_enderecoNumero;
    @Column(name="dc_enderecoBairro", nullable=false, length=30)
    private String dc_enderecoBairro;
    @Column(name="dc_telefone", nullable=false, length=30)
    private String dc_telefone;
    @Column(name="dc_responsavel", nullable=false, length=45)
    private String dc_responsavel; 
    @Column(name="fk_municipio", nullable=false, length=5)
    private Integer fk_municipio;

    @OneToMany(mappedBy = "filial", fetch = FetchType.LAZY)
    @ForeignKey(name="fkFilial")
    private List<Usuario> usuarios;
    
    @ManyToOne(optional=false)
    @ForeignKey(name="fk_municipio")
    private Filial filial;
    
    public Filial() {
    }

    public Integer getId_Filial() {
        return id_Filial;
    }

    public void setId_Filial(Integer id_Filial) {
        this.id_Filial = id_Filial;
    }

    public String getDc_nomeFilial() {
        return dc_nomeFilial;
    }

    public void setDc_nomeFilial(String dc_nomeFilial) {
        this.dc_nomeFilial = dc_nomeFilial;
    }

    public String getDc_endereco() {
        return dc_endereco;
    }

    public void setDc_endereco(String dc_endereco) {
        this.dc_endereco = dc_endereco;
    }

    public String getDc_enderecoNumero() {
        return dc_enderecoNumero;
    }

    public void setDc_enderecoNumero(String dc_enderecoNumero) {
        this.dc_enderecoNumero = dc_enderecoNumero;
    }

    public String getDc_enderecoBairro() {
        return dc_enderecoBairro;
    }

    public void setDc_enderecoBairro(String dc_enderecoBairro) {
        this.dc_enderecoBairro = dc_enderecoBairro;
    }

    public String getDc_telefone() {
        return dc_telefone;
    }

    public void setDc_telefone(String dc_telefone) {
        this.dc_telefone = dc_telefone;
    }

    public String getDc_responsavel() {
        return dc_responsavel;
    }

    public void setDc_responsavel(String dc_responsavel) {
        this.dc_responsavel = dc_responsavel;
    }

    public Integer getFk_municipio() {
        return fk_municipio;
    }

    public void setFk_municipio(Integer fk_municipio) {
        this.fk_municipio = fk_municipio;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.id_Filial != null ? this.id_Filial.hashCode() : 0);
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
        final Filial other = (Filial) obj;
        if (this.id_Filial != other.id_Filial && (this.id_Filial == null || !this.id_Filial.equals(other.id_Filial))) {
            return false;
        }
        return true;
    }




}


