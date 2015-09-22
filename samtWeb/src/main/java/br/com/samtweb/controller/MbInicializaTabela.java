
package br.com.samtweb.controller;

import br.com.samtweb.model.dao.HibernateDAO;
import br.com.samtweb.model.dao.InterfaceDAO;
import br.com.samtweb.model.entities.Infracao;
import br.com.samtweb.util.FacesContextUtil;
import java.util.List;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 22/09/2015
 */

@ManagedBean(name="mbInicializaTabela")
@SessionScoped
public class MbInicializaTabela implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Infracao infracao = new Infracao();
    
    public MbInicializaTabela(){
    }

    private InterfaceDAO<Infracao> infracaoDAO(){
        InterfaceDAO<Infracao> infracaoDAO = new HibernateDAO<Infracao>(Infracao.class, FacesContextUtil.getRequestSession());
        return infracaoDAO;
    }
    
    public void iniciar(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Iniciando tabelas...",""));
    
    }
}
