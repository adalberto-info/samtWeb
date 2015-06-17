
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
        if (municipio.getId_municipio() == null || municipio.getId_municipio() == 0){
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
        municipioDAO().update(municipio);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso!",""));
    }

    public void deleteMunicipio(){
        municipioDAO().remove(municipio);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso!",""));
    } 
    
    public Municipio getMunicipio(){
        return municipio;
    }
    
    public void setMuncipio(Municipio municipio){
        this.municipio = municipio;
    } 
    
    public List<Municipio> getMunicipios(){
        municipios = municipioDAO().getEntities();
        return municipios;
    }
    
    
    public void setMunicipios(List<Municipio> municipios){
        this.municipios = municipios;
    }
}
