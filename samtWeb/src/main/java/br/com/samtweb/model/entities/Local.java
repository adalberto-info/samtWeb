
package br.com.samtweb.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 04/11/2015
 */

@Entity
@Table(name="local")
public class Local implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_codigoLocal", nullable=false, length=4)
    private int id_codigoLocal;
    @Column(name="fk_empresa", nullable=false, length=10)
    private int fk_empresa; 
    @Column(name="fk_codigoLocalPai", nullable=false, length=4)
    private int fk_codigoLocalPai;
    @Column(name="dc_codigoCliente", nullable=false, length=10)
    private String dc_codigoCliente; 
    @Column(name="dc_local", nullable=false, length=80)
    private String dc_local; 
    @Column(name="dc_bairro", nullable=false, length=15)
    private String dc_bairro; 
    @Column(name="dc_complemento", nullable=false, length=50)
    private String dc_complemento; 
    @Column(name="dc_sentido", nullable=false, length=50)
    private String dc_sentido; 
    @Column(name="fk_municipio", nullable=false, length=5)
    private int fk_municipio; 
    @Column(name="nr_latitude", nullable=false, precision=11, scale=8)
    private Float nr_latitude; 
    @Column(name="nr_longitude", nullable=false, precision=11, scale=8)
    private Float nr_longitude; 
    @Column(name="fk_tipoComunicacao", nullable=false, length=2)
    private int fk_tipoComunicacao; 
    @Column(name="dc_ip", nullable=false, length=15)
    private String dc_ip; 
    @Column(name="dh_atualizacaoIp", nullable=false, length=20)
    private String dh_atualizacaoIp; 
    @Column(name="nr_distanciaRegua", nullable=false, precision=4, scale=2)
    private Float nr_distanciaRegua;
    @Column(name="dc_lado", nullable=false, length=8)
    private String dc_lado; 

    public int getId_codigoLocal() {
        return id_codigoLocal;
    }

    public void setId_codigoLocal(int id_codigoLocal) {
        this.id_codigoLocal = id_codigoLocal;
    }

    public int getFk_empresa() {
        return fk_empresa;
    }

    public void setFk_empresa(int fk_empresa) {
        this.fk_empresa = fk_empresa;
    }

    public int getFk_codigoLocalPai() {
        return fk_codigoLocalPai;
    }

    public void setFk_codigoLocalPai(int fk_codigoLocalPai) {
        this.fk_codigoLocalPai = fk_codigoLocalPai;
    }

    public String getDc_codigoCliente() {
        return dc_codigoCliente;
    }

    public void setDc_codigoCliente(String dc_codigoCliente) {
        this.dc_codigoCliente = dc_codigoCliente;
    }

    public String getDc_local() {
        return dc_local;
    }

    public void setDc_local(String dc_local) {
        this.dc_local = dc_local;
    }

    public String getDc_bairro() {
        return dc_bairro;
    }

    public void setDc_bairro(String dc_bairro) {
        this.dc_bairro = dc_bairro;
    }

    public String getDc_complemento() {
        return dc_complemento;
    }

    public void setDc_complemento(String dc_complemento) {
        this.dc_complemento = dc_complemento;
    }

    public String getDc_sentido() {
        return dc_sentido;
    }

    public void setDc_sentido(String dc_sentido) {
        this.dc_sentido = dc_sentido;
    }

    public int getFk_municipio() {
        return fk_municipio;
    }

    public void setFk_municipio(int fk_municipio) {
        this.fk_municipio = fk_municipio;
    }

    public Float getNr_latitude() {
        return nr_latitude;
    }

    public void setNr_latitude(Float nr_latitude) {
        this.nr_latitude = nr_latitude;
    }

    public Float getNr_longitude() {
        return nr_longitude;
    }

    public void setNr_longitude(Float nr_longitude) {
        this.nr_longitude = nr_longitude;
    }

    public int getFk_tipoComunicacao() {
        return fk_tipoComunicacao;
    }

    public void setFk_tipoComunicacao(int fk_tipoComunicacao) {
        this.fk_tipoComunicacao = fk_tipoComunicacao;
    }

    public String getDc_ip() {
        return dc_ip;
    }

    public void setDc_ip(String dc_ip) {
        this.dc_ip = dc_ip;
    }

    public String getDc_atualizacaoIp() {
        return dh_atualizacaoIp;
    }

    public void setDc_atualizacaoIp(String dc_atualizacaoIp) {
        this.dh_atualizacaoIp = dc_atualizacaoIp;
    }

    public Float getNr_distanciaRegua() {
        return nr_distanciaRegua;
    }

    public void setNr_distanciaRegua(Float nr_distanciaRegua) {
        this.nr_distanciaRegua = nr_distanciaRegua;
    }

    public String getDc_lado() {
        return dc_lado;
    }

    public void setDc_lado(String dc_lado) {
        this.dc_lado = dc_lado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id_codigoLocal;
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
        final Local other = (Local) obj;
        if (this.id_codigoLocal != other.id_codigoLocal) {
            return false;
        }
        return true;
    }
    
    
}
