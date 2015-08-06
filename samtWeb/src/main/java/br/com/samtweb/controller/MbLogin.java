package br.com.samtweb.controller;

//import org.springframework.security.ui.AbstractProcessingFilter;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.authentication.AbstractProcessingFilter;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 04/08/2015
 */
@ManagedBean(name = "mbLogin")
@SessionScoped
public class MbLogin {

private String dc_nomeUsuario;
private String dc_senha;

public MbLogin() {

    Exception ex = (Exception) FacesContext
             .getCurrentInstance()
             .getExternalContext()
             .getSessionMap()
             .get(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY);

    if (ex != null)
        FacesContext.getCurrentInstance().addMessage(
                 null,
                 new FacesMessage(FacesMessage.SEVERITY_ERROR, ex
                        .getMessage(), ex.getMessage()));

}


public String getDc_nomeUsuario() {
    return dc_nomeUsuario;
}

public void setDc_nomeUsuario(String dc_nomeUsuario) {
    this.dc_nomeUsuario = dc_nomeUsuario;
}

public String getDc_senha() {
    return dc_senha;
}

public void setDc_senha(String dc_senha) {
   this.dc_senha = dc_senha;
}

public void login(ActionEvent e) throws java.io.IOException {
    HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//    FacesContext.getCurrentInstance().getExternalContext().redirect("/spring-authentication/j_spring_security_check?j_username=" + dc_nomeUsuario + "&j_password=" + dc_senha);
    FacesContext.getCurrentInstance().getExternalContext().redirect("/j_spring_security_check?j_username=" + dc_nomeUsuario + "&j_password=" + dc_senha);
}

}
