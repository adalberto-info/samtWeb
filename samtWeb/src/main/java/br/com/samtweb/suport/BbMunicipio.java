
package br.com.samtweb.suport;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 16/06/2015
 */

import br.com.samtweb.model.dao.HibernateDAO;
import br.com.samtweb.model.dao.InterfaceDAO;
import br.com.samtweb.model.entities.Municipio;
import br.com.samtweb.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bbMunicipio")
@RequestScoped

public class BbMunicipio implements Serializable{

    private static final long serialVersionUID = 1L;
    
    public BbMunicipio(){
        
    }
    
    public List<Municipio> getMunicipios(){
        InterfaceDAO<Municipio> municipioDAO = new HibernateDAO<Municipio>(Municipio.class, FacesContextUtil.getRequestSession());
        return municipioDAO.getEntities();
    }
    
    
}
