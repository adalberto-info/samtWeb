
package br.com.samtweb.model.entities;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 04/09/2015
 */

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="veiculo")
public class Veiculo implements Serializable {
   private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_veiculo", nullable=false, length=10)
    private int id_veiculo;
    @Column(name="dc_placa", nullable=false, length=16)
    private String dc_placa;
    @Column(name="fk_especie", nullable=false, precision=3, scale=0)
    private int fk_especie;
    @Column(name="fk_marcaDenatran", nullable=false, length=6)
    private int fk_marcaDenatran;
    @Column(name="fk_cor", nullable=false, length=3)
    private int fk_cor;
    @Column(name="fk_categoria", nullable=false, length=2)
    private int fk_categoria;
    @Column(name="fk_tipo", nullable=false, length=3)
    private int fk_tipo;
    @Column(name="fk_municipio", nullable=false, length=5)
    private int fk_municipio;
    @Column(name="nr_anoModelo", nullable=false, length=4)
    private int nr_anoModelo;
    @Column(name="nr_renavam", nullable=false, length=11)
    private int nr_renavam;

    public int getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(int id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public String getDc_placa() {
        return dc_placa;
    }

    public void setDc_placa(String dc_placa) {
        this.dc_placa = dc_placa;
    }

    public int getFk_especie() {
        return fk_especie;
    }

    public void setFk_especie(int fk_especie) {
        this.fk_especie = fk_especie;
    }

    public int getFk_marcaDenatran() {
        return fk_marcaDenatran;
    }

    public void setFk_marcaDenatran(int fk_marcaDenatran) {
        this.fk_marcaDenatran = fk_marcaDenatran;
    }

    public int getFk_cor() {
        return fk_cor;
    }

    public void setFk_cor(int fk_cor) {
        this.fk_cor = fk_cor;
    }

    public int getFk_categoria() {
        return fk_categoria;
    }

    public void setFk_categoria(int fk_categoria) {
        this.fk_categoria = fk_categoria;
    }

    public int getFk_tipo() {
        return fk_tipo;
    }

    public void setFk_tipo(int fk_tipo) {
        this.fk_tipo = fk_tipo;
    }

    public int getFk_municipio() {
        return fk_municipio;
    }

    public void setFk_municipio(int fk_municipio) {
        this.fk_municipio = fk_municipio;
    }

    public int getNr_anoModelo() {
        return nr_anoModelo;
    }

    public void setNr_anoModelo(int nr_anoModelo) {
        this.nr_anoModelo = nr_anoModelo;
    }

    public int getNr_renavam() {
        return nr_renavam;
    }

    public void setNr_renavam(int nr_renavam) {
        this.nr_renavam = nr_renavam;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_veiculo;
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
        final Veiculo other = (Veiculo) obj;
        return true;
    }
    
    
    
}
