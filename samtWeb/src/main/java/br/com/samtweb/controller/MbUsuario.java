package br.com.samtweb.controller;

import br.com.samtweb.model.dao.HibernateDAO;
import br.com.samtweb.model.dao.InterfaceDAO;
import br.com.samtweb.model.entities.Filial;
import br.com.samtweb.model.entities.Usuario;
import br.com.samtweb.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 27/05/2015
 */
@ManagedBean(name = "mbUsuario")
@SessionScoped
public class MbUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario = new Usuario();
    private Filial filial = new Filial(); 
    
    private List<Usuario> usuarios;
    private List<Filial> filiais;
    
    public MbUsuario() {
    }

    private InterfaceDAO<Usuario> usuarioDAO() {
        InterfaceDAO<Usuario> usuarioDAO = new HibernateDAO<Usuario>(Usuario.class, FacesContextUtil.getRequestSession());
        return usuarioDAO;
    }

    private InterfaceDAO<Filial> filialDAO() {
        InterfaceDAO<Filial> filialDAO = new HibernateDAO<Filial>(Filial.class, FacesContextUtil.getRequestSession());
        return filialDAO;
    }
    
    public String limpaUsuario() {
        usuario = new Usuario();
        filial = new Filial();
        return editUsuario();
    }

    public String editUsuario() {
        return "/restrict/cadastrarUsuario.faces";
    }

    public String addUsuario() {
        if (usuario.getId_usuario() == null || usuario.getId_usuario() == 0) {
            insertUsuario();
        } else {
            updateUsuario();
        }
        limpaUsuario();
        return null;
    }

    private void insertUsuario() {
        usuarioDAO().save(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso!", ""));
    }

    private void updateUsuario() {
        usuarioDAO().update(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso!", ""));
    }

    public void deleteUsuario(){
        usuarioDAO().remove(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso!", ""));
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        usuarios = usuarioDAO().getEntities();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Filial> getFiliais() {
        return filiais;
    }

    public void setFiliais(List<Filial> filiais) {
        filiais = filialDAO().getEntities();
        this.filiais = filiais;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }


}
