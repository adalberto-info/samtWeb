package br.com.samtweb.controller;

import br.com.samtweb.model.dao.HibernateDAO;
import br.com.samtweb.model.dao.InterfaceDAO;
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
@ManagedBean(name = "mbCidade")
@SessionScoped
public class MbUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;

    public MbUsuario() {
    }

    private InterfaceDAO<Usuario> usuarioDAO() {
        InterfaceDAO<Usuario> usuarioDAO = new HibernateDAO<Usuario>(Usuario.class, FacesContextUtil.getRequestSession());
        return usuarioDAO;
    }

    public String limpaUsuario() {
        usuario = new Usuario();
        return "/restrict/cadastrarUsuario.faces";
    }

    public String editUsuario() {
        return "/restrict/cadastrarUsuario.faces";
    }

    public String addUsuario() {
        if (usuario.getIdUsuario() == null || usuario.getIdUsuario() == 0) {
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
    
    
}
