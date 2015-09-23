
package br.com.samtweb.controller;

import br.com.samtweb.model.dao.HibernateDAO;
import br.com.samtweb.model.dao.InterfaceDAO;
import br.com.samtweb.model.entities.Infracao;
import br.com.samtweb.util.FacesContextUtil;
import br.com.samtweb.util.HibernateUtil;
import java.util.List;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


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
     
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Inicializando tabelas...",""));
        deletaInfracao();
    }
    
    private void deletaInfracao(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Passo 1...",""));
        String stringQuery = "delete from infracao ";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Passo 2...",""));
 //       Session session = FacesContextUtil.getRequestSession();
        Session session = getSession();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Passo 3...",""));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Session: " + session,""));
        Query query = session.createQuery("delete from infracao");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Passo 4...",""));
        int resultado = query.executeUpdate();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registros excluídos da tabela infracao...",""));
    }
    
    
    public static Session getSession() {
		Session session = (Session) MbInicializaTabela.session.get();
		
		if (session == null) {
			session = sessionFactory.openSession();
			MbInicializaTabela.session.set(session);
		}
	
		return session;
	}

        private static final ThreadLocal session = new ThreadLocal();

	private static final SessionFactory sessionFactory =
		new AnnotationConfiguration().configure().buildSessionFactory();



}
