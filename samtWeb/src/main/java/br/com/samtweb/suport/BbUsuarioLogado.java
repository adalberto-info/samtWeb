
package br.com.samtweb.suport;

import br.com.samtweb.model.entities.Usuario;
import br.com.samtweb.util.FacesContextUtil;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 28/07/2015
 */
@ManagedBean(name="bbUsuarioLogado")
@SessionScoped
public class BbUsuarioLogado implements Serializable{

    private static final long serialVersionUID = 1L;
    private Usuario usuario;
    
    public BbUsuarioLogado() {
   
        usuario = new Usuario();
        SecurityContext context = SecurityContextHolder.getContext();
        if(context instanceof SecurityContext){
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication){
                usuario.setDc_nomeUsuario(((User) authentication.getPrincipal()).getUsername());
            }
        }
        
    }
    
    public Usuario procuraUsuario(){
        String dc_nomeUsuario = getDc_nomeUsuarioLogado();
        Session session = FacesContextUtil.getRequestSession();
        Query query = session.createQuery("from Usuario usu where usu.dc_nomeUsuario like ?");
        query.setString(0, dc_nomeUsuario);
        
        return (Usuario) query.uniqueResult();        
    }

    private String getDc_nomeUsuarioLogado() {
        return usuario.getDc_nomeUsuario();
    }
    
}
