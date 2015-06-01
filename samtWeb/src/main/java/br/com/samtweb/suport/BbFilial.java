
package br.com.samtweb.suport;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 01/06/2015
 */

import br.com.samtweb.model.dao.HibernateDAO;
import br.com.samtweb.model.dao.InterfaceDAO;
import br.com.samtweb.model.entities.Filial;
import br.com.samtweb.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bbFilial")
@RequestScoped
public class BbFilial  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<Filial> getFilial(){
        InterfaceDAO<Filial> filialDAO = new HibernateDAO<Filial>(Filial.class, FacesContextUtil.getRequestSession());
        return filialDAO.getEntities();
    }
    
}

    

