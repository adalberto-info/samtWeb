
package br.com.samtweb.suport;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 17/06/2015
 */

import br.com.samtweb.model.dao.HibernateDAO;
import br.com.samtweb.model.dao.InterfaceDAO;
import br.com.samtweb.model.entities.Uf;
import br.com.samtweb.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bbUf")
@RequestScoped
public class BbUf implements Serializable{

    private static final long serialVersionUID = 1L;
    
    public BbUf(){
    }

    public List<Uf> getUfs(){
        InterfaceDAO<Uf> ufDAO = new HibernateDAO<Uf>(Uf.class, FacesContextUtil.getRequestSession());
        return ufDAO.getEntities();
    }
    
}
