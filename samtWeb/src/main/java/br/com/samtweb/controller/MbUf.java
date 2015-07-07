
package br.com.samtweb.controller;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 07/07/2015
 */

import br.com.samtweb.model.dao.HibernateDAO;
import br.com.samtweb.model.dao.InterfaceDAO;
import br.com.samtweb.model.entities.Uf;
import br.com.samtweb.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;


@ManagedBean("MbUf")
@SessionScoped
public class MbUf implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Uf uf = new Uf();
    
    private List<Uf> Ufs;
    
    public MbUf(){
    }
    
    private InterfaceDAO<Uf> ufDAO(){
        InterfaceDAO<Uf> ufDAO = new HibernateDAO<Uf>(Uf.class, FacesContextUtil.getRequestSession());
        return ufDAO;
    }
    
    public String limpaUf(){
        uf = new Uf();
        return editUf();
    }
    
    public String editUf(){
        return "restrict/consultarUF.faces";
    }

    public String addUf(){
        if(uf.getId_uf() == null || uf.getId_uf() == 0){
            insertUf();
        }else{
            updateUf();
        }
    }
    
    public 
    
    
}
