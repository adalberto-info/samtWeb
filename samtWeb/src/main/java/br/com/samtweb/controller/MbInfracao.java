
package br.com.samtweb.controller;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 01/10/2015
 */


import br.com.samtweb.model.dao.HibernateDAO;
import br.com.samtweb.model.dao.InterfaceDAO;
import br.com.samtweb.model.entities.Infracao;
import br.com.samtweb.util.FacesContextUtil;
import br.com.samtweb.model.consult.InfracaoVeiculo;
import java.io.Serializable;
import java.util.List;
import java.util.ListIterator;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;

@ManagedBean(name="mbInfracao")
@SessionScoped
public class MbInfracao implements Serializable {
    private static final long serialVersioUID = 1L;

    private Infracao infracao = new Infracao();
    private InfracaoVeiculo infracaoVeiculo = new InfracaoVeiculo();
    
    private List<Infracao> infracoes;
    private List<InfracaoVeiculo> infracaoVeiculos;
    private ListIterator<Infracao> listIterator;
    private int vln_indice = 0;
    
    public MbInfracao(){
	getInfracoes();
	this.infracao = this.infracoes.get(vln_indice);
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
    }

    public void anteriorRegistro(){
        vln_indice--; 
        if (vln_indice < 0){
            vln_indice = 0;
        } 
        this.infracao = this.infracoes.get(vln_indice);

    }

    public void procuraPlaca(String placa){
    
        Session session = FacesContextUtil.getRequestSession();
        String vlc_sql, vlc_parametrosSQL; 
        int vln_resultado = 0; 
        
//        vlc_sql = "select a.* from veiculo a where a.dc_placa = '" + placa + "' ";
  
        vlc_sql = "select a.dc_placa, a.fk_categoria, a.fk_cor, a.fk_especie, a.fk_marcaDenatran, ";
        vlc_sql += "a.fk_municipio, a.fk_tipo, a.nr_anoModelo, a.nr_renavam, b.descricao as dc_categoria, ";
        vlc_sql += "c.descricao as dc_cor, d.dc_descricao as dc_especie, e.dc_descricao as dc_marcaDenatran, ";
        vlc_sql += "f.descricao as dc_municipio, g.descricao as dc_tipo ";
        vlc_sql += "from veiculo " ;
        vlc_sql += "inner join categoriaVeiculo b on a.fk_categoria = b.id_categoria ";
        vlc_sql += "inner join corVeiulo c on a.fk_cor = c.id_cor ";
        vlc_sql += "inner join especieVeiulo d on a.fk_especie = d.id_especie ";
        vlc_sql += "inner join municipio f on a.fk_municipio = f.id_municipio ";
        vlc_sql += "inner join tipoVeiculo g on a.fk_tipo = g.id_tipo ";
        
        
        Query query = session.createSQLQuery(vlc_sql);
        infracaoVeiculos = query.list();
        
        
    }

    
}
