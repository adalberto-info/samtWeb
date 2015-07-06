
package br.com.samtweb.controller;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 17/06/2015
 */


import br.com.samtweb.model.dao.HibernateDAO;
import br.com.samtweb.model.dao.InterfaceDAO;
import br.com.samtweb.model.entities.Municipio;
import br.com.samtweb.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;


@ManagedBean(name="mbMunicipio")
@SessionScoped
public class MbMunicipio implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Municipio municipio = new Municipio();
    
    private List<Municipio> municipios; 
    
    public MbMunicipio(){
    }

    private InterfaceDAO<Municipio> municipioDAO() {
        InterfaceDAO<Municipio> municipioDAO = new HibernateDAO<Municipio>(Municipio.class, FacesContextUtil.getRequestSession());
        return municipioDAO;
    }
    
    public String limpaMunicipio(){
        municipio = new Municipio();
        return editMunicipio();
    }
    
    public String editMunicipio(){
        return "restrict/cadastrarMunicipio.faces";
    }
    
    public String addMunicipio(){
        Integer VLN_id_municipio ;
        VLN_id_municipio = municipio.getId_municipio();

        Municipio municipioPesquisa = findMunicipio(VLN_id_municipio);
        
        if (municipioPesquisa == null || municipioPesquisa.getId_municipio() == 0){
            insertMunicipio();
        } else{
            updateMunicipio();
        }
        limpaMunicipio();
        return null;
    }
    
    private void insertMunicipio(){
        municipioDAO().save(municipio);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso!",""));
    }
    
    private void updateMunicipio(){
        municipioDAO().merge(municipio);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso!",""));
    }

    public void deleteMunicipio(){
        municipioDAO().remove(municipio);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso!",""));
    } 
    
    public Municipio getMunicipio(){
        return municipio;
    }
    
    public void setMunicipio(Municipio municipio){
        this.municipio = municipio;
    } 
    
    public List<Municipio> getMunicipios(){
        municipios = municipioDAO().getEntities();
        return municipios;
    }
    
    
    public void setMunicipios(List<Municipio> municipios){
        this.municipios = municipios;
    }
 
    public Municipio findMunicipio(Integer id_municipio) {
        String stringQuery = "from Municipio municipio where municipio.id_municipio = "+ id_municipio;
        Session session = FacesContextUtil.getRequestSession();
        Query query = session.createQuery(stringQuery);
        return (Municipio) query.uniqueResult();
    }

    
}
