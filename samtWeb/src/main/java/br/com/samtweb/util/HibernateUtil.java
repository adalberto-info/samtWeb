
package br.com.samtweb.util;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 12/05/2015
 */

import javax.validation.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    public static final String HIBERNATE_SESSION = "hibernate_session";
    static{
        try{
            System.out.println("Tentando abrir uma session factory.");
            Configuration configuration = new Configuration().configure();
            ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder();
           
            sessionFactory = configuration.buildSessionFactory();
            
        }catch(Exception e){
            
        }
    }
}
