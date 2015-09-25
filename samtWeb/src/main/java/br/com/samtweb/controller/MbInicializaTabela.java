
package br.com.samtweb.controller;

import br.com.samtweb.model.dao.HibernateDAO;
import br.com.samtweb.model.dao.InterfaceDAO;
import br.com.samtweb.model.entities.Infracao;
import br.com.samtweb.util.FacesContextUtil;
import br.com.samtweb.util.HibernateUtil;
import java.util.List;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 22/09/2015
 */

@ManagedBean(name="mbInicializaTabela")
@SessionScoped
public class MbInicializaTabela implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Infracao infracao = new Infracao();
    
    public MbInicializaTabela(){
    }

    private InterfaceDAO<Infracao> infracaoDAO(){
        InterfaceDAO<Infracao> infracaoDAO = new HibernateDAO<Infracao>(Infracao.class, FacesContextUtil.getRequestSession());
        return infracaoDAO;
    }
    
    public void iniciar(){
     
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Inicializando tabelas...",""));
        deletaInfracao();
        alimentaInfracao();
    }
    
    private void deletaInfracao(){
        
        Session session = FacesContextUtil.getRequestSession();
        int vln_Resultado = session.createSQLQuery("delete from infracao").executeUpdate();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Todos os registros excluídos da tabela infracao...",""));
    }
    
    private void alimentaInfracao(){
        Session session = FacesContextUtil.getRequestSession();
        String vlc_sql, vlc_parametrosSQL; 
        vlc_sql = "insert into infracao (id_hashInfracao,dataJuliana,dc_matriculaAgente,dc_serieEquipameto,";
        vlc_sql += "dc_urlInfracao,dh_recebimento,dh_transferencia,dt_dataInfracaoUTC,dt_dataInfracao,fk_enquadramento,";
        vlc_sql += "fk_processo,fk_status,fk_tipoInconsistencia,hr_horaInfracao,hr_horaInfracaoUTC,lg_veiculoEstado,";
        vlc_sql += "nr_classificaoVeiculo,nr_codigoInfracao,nr_codigoLocal,nr_dataHoraInfracao,nr_distanciaFaixaRetencao,";
        vlc_sql += "nr_distanciaRegistrada,nr_faixa,nr_gravaTarja,nr_latitude,nr_longitude,nr_numeroLinhasTarja,";
        vlc_sql += "nr_numeroSequencialInfracao,nr_numeroSequencialVeiculo,nr_numeroSequencialVeiculoInfrator,nr_porteVeiculo,";
        vlc_sql += "nr_posicaoTarja,nr_sentidoVeiculo,nr_tamanhoVeiculo,nr_tempoPerdaoParada,nr_tempoPerdaoSemaforo,nr_tipoEquipamento,";
        vlc_sql += "nr_tipoImagem,nr_velocidadeConsiderada,nr_velocidadePermitida,nr_velocidadeRegistrada,nr_velocidadeTolerada,";
        vlc_sql += "nr_versao,nr_classificacaoVeiculo) values (";
        vlc_sql += ":vlc_id_hashInfracao, :vlc_dataJuliana";
        Query query = session.createSQLQuery(vlc_sql);
        query.setParameter("vlc_id_hashInfracao", "1");
        int vln_resultado = query.executeUpdate();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido registros na tabela infracao...",""));
    }
}
