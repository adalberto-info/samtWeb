
package br.com.samtweb.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @Column(name="id_filial", nullable=false, length=10)
    private Integer id_filial;
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
    
    @OneToMany(mappedBy = "filial", fetch = FetchType.LAZY)
    @ForeignKey(name="FilialUsuario")
    private List<Usuario> usuarios;
    
    @ManyToOne(optional=false)
    @ForeignKey(name="FilialMunicipio")
    @JoinColumn(name="fk_municipio", referencedColumnName="id_municipio")
    private Municipio municipio;
    
    public Filial() {
        this.municipio = new Municipio();
    }

    public Integer getId_filial() {
        return id_filial;
    }

    public void setId_filial(Integer id_filial) {
        this.id_filial = id_filial;
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

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
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
        hash = 79 * hash + (this.id_filial != null ? this.id_filial.hashCode() : 0);
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
        if (this.id_filial != other.id_filial && (this.id_filial == null || !this.id_filial.equals(other.id_filial))) {
            return false;
        }
        return true;
    }




}


