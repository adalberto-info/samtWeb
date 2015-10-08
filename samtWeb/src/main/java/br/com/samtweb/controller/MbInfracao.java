
package br.com.samtweb.controller;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 01/10/2015
 */


import br.com.samtweb.model.dao.HibernateDAO;
import br.com.samtweb.model.dao.InterfaceDAO;
import br.com.samtweb.model.entities.Infracao;
import br.com.samtweb.util.FacesContextUtil;
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

    private List<Infracao> infracoes;
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

}
