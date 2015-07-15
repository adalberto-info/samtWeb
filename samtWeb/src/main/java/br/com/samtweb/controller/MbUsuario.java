package br.com.samtweb.controller;

import br.com.samtweb.conversores.ConverterSHA1;
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
@ManagedBean(name = "mbUsuario")
@SessionScoped
public class MbUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dc_confirmaSenha;
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
        usuario.setDc_senha(ConverterSHA1.cipher(usuario.getDc_senha()));
        this.setDc_confirmaSenha(ConverterSHA1.cipher(this.getDc_confirmaSenha()));
        
        if (comparaSenhas()==true){
            usuarioDAO().save(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso!", ""));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Senhas não conferem!", ""));
        }    
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

    public String getDc_confirmaSenha(){
        return this.dc_confirmaSenha;
    }
    
    public void setDc_confirmaSenha(String dc_confirmaSenha){
        this.dc_confirmaSenha = dc_confirmaSenha;
    }

    private boolean comparaSenhas() {
        
        boolean vll_retorno;
        vll_retorno = true;

        if (usuario.getDc_senha().equals(this.dc_confirmaSenha)){
            vll_retorno = true;
        }else{
            vll_retorno = false;
        }
            
        return vll_retorno;
        
    }
}
