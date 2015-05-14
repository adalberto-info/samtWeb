package br.com.samtweb.util;

import javax.faces.context.FacesContext;
import org.hibernate.Session;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 14/05/2015
 */
public class FacesContextUtil {

    private static final String HIBERNATE_SESSION = "hibernate_session";

    public static Session getRequestSession() {
        return (Session)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(HIBERNATE_SESSION);
    }

    public static void setRequestSession(Session session) {
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBERNATE_SESSION, session);
    }

}
