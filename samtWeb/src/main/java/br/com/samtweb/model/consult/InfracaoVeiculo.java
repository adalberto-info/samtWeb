
package br.com.samtweb.model.consult;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 19/10/2015
 */
public class InfracaoVeiculo {
    private int id_veiculo;
    private String dc_placa;
    private int fk_especie;
    private int fk_marcaDenatran;
    private int fk_cor;
    private int fk_categoria;
    private int fk_tipo;
    private int fk_municipio;
    private int nr_anoModelo;
    private int nr_renavam;

    private String dc_especie;
    private String dc_marcaDenatran;
    private String dc_cor;
    private String dc_categoria;
    private String dc_tipo;
    private String dc_municipio;
    private String dc_uf;

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

    public String getDc_especie() {
        return dc_especie;
    }

    public void setDc_especie(String dc_especie) {
        this.dc_especie = dc_especie;
    }

    public String getDc_marcaDenatran() {
        return dc_marcaDenatran;
    }

    public void setDc_marcaDenatran(String dc_marcaDenatran) {
        this.dc_marcaDenatran = dc_marcaDenatran;
    }

    public String getDc_cor() {
        return dc_cor;
    }

    public void setDc_cor(String dc_cor) {
        this.dc_cor = dc_cor;
    }

    public String getDc_categoria() {
        return dc_categoria;
    }

    public void setDc_categoria(String dc_categoria) {
        this.dc_categoria = dc_categoria;
    }

    public String getDc_tipo() {
        return dc_tipo;
    }

    public void setDc_tipo(String dc_tipo) {
        this.dc_tipo = dc_tipo;
    }

    public String getDc_municipio() {
        return dc_municipio;
    }

    public void setDc_municipio(String dc_municipio) {
        this.dc_municipio = dc_municipio;
    }

    public String getDc_uf() {
        return dc_uf;
    }

    public void setDc_uf(String dc_uf) {
        this.dc_uf = dc_uf;
    }

    
}
