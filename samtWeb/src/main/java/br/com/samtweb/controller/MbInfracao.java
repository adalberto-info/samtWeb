
package br.com.samtweb.controller;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 01/10/2015
 */


import br.com.samtweb.model.consult.InfracaoVeiculo;
import br.com.samtweb.model.dao.HibernateDAO;
import br.com.samtweb.model.dao.InterfaceDAO;
import br.com.samtweb.model.entities.Infracao;
import br.com.samtweb.util.FacesContextUtil;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

@ManagedBean(name="mbInfracao")
@SessionScoped
public class MbInfracao implements Serializable {
    private static final long serialVersioUID = 1L;

    private Infracao infracao = new Infracao();
    private InfracaoVeiculo infracaoVeiculo = new InfracaoVeiculo();

    private List<Infracao> infracoes;
    private List<InfracaoVeiculo> infracaoVeiculos;
    private List lista;
    private int vln_indice = 0;

    public MbInfracao(){
	getInfracoes();
	this.infracao = this.infracoes.get(vln_indice);
        procuraPlaca(infracao.getDc_placaVeiculo());
    }

    private InterfaceDAO<Infracao> infracaoDAO(){
        InterfaceDAO<Infracao> infracaoDAO= new HibernateDAO<Infracao>(Infracao.class, FacesContextUtil.getRequestSession());
        return infracaoDAO;
    }

    public void limpaInfracao(){
        infracao = new Infracao();
    }

    public Infracao getInfracao(){
        return infracao;
    }

    public void setInfracao(Infracao infracao){
        this.infracao = infracao;
    }

    public List<Infracao> getInfracoes(){
        infracoes = infracaoDAO().getEntities();
        return infracoes;
    }

    public void proximoRegistro() {
        vln_indice++;
        if (vln_indice > (this.infracoes.size()-1)){
            vln_indice = (this.infracoes.size()-1);
        }
        this.infracao = this.infracoes.get(vln_indice);
        procuraPlaca(infracao.getDc_placaVeiculo());
    }

    public void anteriorRegistro(){
        vln_indice--;
        if (vln_indice < 0){
            vln_indice = 0;
        }
        this.infracao = this.infracoes.get(vln_indice);
        procuraPlaca(infracao.getDc_placaVeiculo());
    }

    public void procuraPlaca(String placa){

        Session session = FacesContextUtil.getRequestSession();
        String vlc_sql, vlc_parametrosSQL;
        int vln_resultado = 0;

        vlc_sql = "select a.dc_placa, a.fk_categoria, a.fk_cor, a.fk_especie, a.fk_marcaDenatran, ";
        vlc_sql += "a.fk_municipio, a.fk_tipo, a.nr_anoModelo, a.nr_renavam, ifnull(b.dc_descricao,' ') as dc_categoria, ";
        vlc_sql += "ifnull(c.dc_descricao,' ') as dc_cor, ifnull(d.dc_descricao,' ') as dc_especie, ifnull(e.dc_descricao,' ') as dc_marcaDenatran, ";
        vlc_sql += "ifnull(f.dc_municipio,' ') as dc_municipio, ifnull(g.dc_descricao,' ') as dc_tipo, ifnull(h.dc_sigla, ' ') as dc_uf  ";
        vlc_sql += "from veiculo a " ;
        vlc_sql += "left join categoriaVeiculo b on a.fk_categoria = b.id_categoria ";
        vlc_sql += "left join corVeiculo c on a.fk_cor = c.id_cor ";
        vlc_sql += "left join especieVeiculo d on a.fk_especie = d.id_especie ";
        vlc_sql += "left join marcaDenatranVeiculo e on a.fk_marcaDenatran = e.id_marcaDenatran ";
        vlc_sql += "left join municipio f on a.fk_municipio = f.id_municipio ";
        vlc_sql += "left join tipoVeiculo g on a.fk_tipo = g.id_tipo ";
        vlc_sql += "left join uf h on f.fk_uf = h.id_uf ";
        vlc_sql += "where a.dc_placa = '" + placa + "' ";

        SQLQuery query = session.createSQLQuery(vlc_sql);
        lista = query.list();

        Iterator iterator = lista.iterator();
        
        if (iterator.hasNext()){
            Object[] row = (Object[])iterator.next();
            infracaoVeiculo.setDc_categoria(row[9].toString());
            infracaoVeiculo.setDc_cor(row[10].toString());
            infracaoVeiculo.setDc_especie(row[11].toString());
            infracaoVeiculo.setDc_marcaDenatran(row[12].toString());
            infracaoVeiculo.setDc_municipio(row[13].toString());
            infracaoVeiculo.setDc_tipo(row[14].toString());
            infracaoVeiculo.setDc_uf(row[15].toString());
            infracaoVeiculo.setNr_anoModelo(Integer.parseInt(row[7].toString()));
        }


    }

    public InfracaoVeiculo getInfracaoVeiculo(){
        return this.infracaoVeiculo;
    }

    public void setInfracaoVeiculo(InfracaoVeiculo infracaoVeiculo){
        this.infracaoVeiculo = infracaoVeiculo;
    }

    public List<InfracaoVeiculo> getInfracaoVeiculos(){
        return infracaoVeiculos;
    }


}
