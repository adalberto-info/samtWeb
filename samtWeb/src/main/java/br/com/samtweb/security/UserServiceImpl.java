package br.com.samtweb.security;

import br.com.samtweb.model.dao.HibernateDAO;
import br.com.samtweb.model.dao.InterfaceDAO;
import br.com.samtweb.model.entities.Usuario;
import br.com.samtweb.util.FacesContextUtil;
import br.com.samtweb.conversores.ConverterSHA1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("samtUserService")
public class UserServiceImpl implements UserDetailsService, Serializable {

    private static final long serialVersionUID = 1L;
    ConverterSHA1 converterSHA1 = new ConverterSHA1();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username != null && username.isEmpty()) {
            throw new UsernameNotFoundException("Usuario nao encontrado!");
        } else {
            try {
                Usuario usuario = findUser(username);

                String login = usuario.getDc_nomeUsuario();
                String password = converterSHA1.descriptografa(usuario.getDc_senha());
                boolean enabled = true; //userBean.isActive()
                boolean accountNonExpired = true;//userBean.isActive()
                boolean credentialsNonExpired = true; //userBean.isActive()
                boolean accountNonLocked = true; //userBean.isActive()

                Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                //Use assim se você usa o Spring Security 3.0.5.RELEASE
//                authorities.add(GrantedAuthorityImpl("ROLE_ADMIN"));
                authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
                //Já na versão 3.1.3.RELEASE essa classe foi depreciada e você deve usar como no trecho abaixo
//                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                User user = new User(
                        login,
                        password,
                        enabled,
                        accountNonExpired,
                        credentialsNonExpired,
                        accountNonLocked,
                        authorities);
                return user;
            } catch (Exception e) {
                return null;
            }
        }

    }

    public Usuario findUser(String login) {
        String stringQuery = "from Usuario usuario where usuario.dc_nomeUsuario = "+ login;
//        return pessoaDAO().getEntityByHQLQuery(stringQuery);
        Session session = FacesContextUtil.getRequestSession();
        Query query = session.createQuery(stringQuery);
        //query.setString(0, login);
        return (Usuario) query.uniqueResult();
    }
    
    private InterfaceDAO<Usuario> usuarioDAO() {
        InterfaceDAO<Usuario> usuarioDAO = new HibernateDAO<Usuario>(Usuario.class, FacesContextUtil.getRequestSession());
        return usuarioDAO;
    }
}