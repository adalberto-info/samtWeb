
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
        int vln_resultado = 0; 
        

        
        vlc_sql = "insert into infracao (id_hashInfracao,dc_numeroAit,dc_placaVeiculo,dataJuliana,dc_matriculaAgente,dc_serieEquipameto,";
        vlc_sql += "dc_urlInfracao,dh_recebimento,dh_transferencia,dt_dataInfracaoUTC,dt_dataInfracao,fk_enquadramento,";
        vlc_sql += "fk_processo,fk_status,fk_tipoInconsistencia,hr_horaInfracao,hr_horaInfracaoUTC,lg_veiculoEstado,";
        vlc_sql += "nr_classificacaoVeiculo,nr_codigoInfracao,nr_codigoLocal,nr_dataHoraInfracao,nr_distanciaFaixaRetencao,";
        vlc_sql += "nr_distanciaRegistrada,nr_faixa,nr_gravaTarja,nr_latitude,nr_longitude,nr_numeroLinhasTarja,";
        vlc_sql += "nr_numeroSequencialInfracao,nr_numeroSequencialVeiculo,nr_numeroSequencialVeiculoInfrator,nr_porteVeiculo,";
        vlc_sql += "nr_posicaoTarja,nr_sentidoVeiculo,nr_tamanhoVeiculo,nr_tempoPerdaoParada,nr_tempoPerdaoSemaforo,nr_tipoEquipamento,";
        vlc_sql += "nr_tipoImagem,nr_velocidadeConsiderada,nr_velocidadePermitida,nr_velocidadeRegistrada,nr_velocidadeTolerada,";
        vlc_sql += "nr_versao) values (";
        vlc_sql += ":vlc_id_hashInfracao, :vlc_dc_numeroAit, :vlc_dc_placaVeiculo, :vlc_dataJuliana, :vlc_dc_matriculaAgente, :vlc_dc_serieEquipamento,";
        vlc_sql += ":vlc_dc_urlInfracao, :vlc_dh_recebimento, :vlc_dh_tranferencia, :vlc_dt_dataInfracaoUTC, :vlc_dt_dataInfracao, :vln_fk_enquadramento, ";
        vlc_sql += ":vln_fk_processo,:vln_fk_status,:vln_fk_tipoInconsistencia,:vlc_hr_horaInfracao,:vlc_hr_horaInfracaoUTC,:vln_lg_veiculoEstado,";
        vlc_sql += ":vln_nr_classificacaoVeiculo,:vln_nr_codigoInfracao,:vln_nr_codigoLocal,:vln_nr_dataHoraInfracao,:vln_nr_distanciaFaixaRetencao,";
        vlc_sql += ":vln_nr_distanciaRegistrada,:vln_nr_faixa,:vln_nr_gravaTarja,:vln_nr_latitude,:vln_nr_longitude,:vln_nr_numeroLinhasTarja,";
        vlc_sql += ":vln_nr_numeroSequencialInfracao,:vln_nr_numeroSequencialVeiculo,:vln_nr_numeroSequencialVeiculoInfrator,:vln_nr_porteVeiculo,";
        vlc_sql += ":vln_nr_posicaoTarja,:vln_nr_sentidoVeiculo,:vln_nr_tamanhoVeiculo,:vln_nr_tempoPerdaoParada,:vln_nr_tempoPerdaoSemaforo,:vln_nr_tipoEquipamento,";
        vlc_sql += ":vln_nr_tipoImagem,:vln_nr_velocidadeConsiderada,:vln_nr_velocidadePermitida,:vln_nr_velocidadeRegistrada,:vln_nr_velocidadeTolerada,";
        vlc_sql += ":vln_nr_versao)";

        
        Query query = session.createSQLQuery(vlc_sql);
        query.setParameter("vlc_id_hashInfracao", "1");
        query.setParameter("vlc_dc_numeroAit", "11111");
        query.setParameter("vlc_dc_placaVeiculo", "EDP8474");
        query.setParameter("vlc_dataJuliana", "999999");
        query.setParameter("vlc_dc_matriculaAgente", "000000");
        query.setParameter("vlc_dc_serieEquipamento", " ");
        query.setParameter("vlc_dc_urlInfracao", "www.engebras.com.br");
        query.setParameter("vlc_dh_recebimento", "");
        query.setParameter("vlc_dh_tranferencia","");
        query.setParameter("vlc_dt_dataInfracaoUTC", "2015-09-28 08:01:02");
        query.setParameter("vlc_dt_dataInfracao", "2015-09-28");
        query.setParameter("vln_fk_enquadramento", 74550); 
        query.setParameter("vln_fk_processo", 2);
        query.setParameter("vln_fk_status", 1);
        query.setParameter("vln_fk_tipoInconsistencia", 0);
        query.setParameter("vlc_hr_horaInfracao", "08:01:02");
        query.setParameter("vlc_hr_horaInfracaoUTC", "08:01:02");
        query.setParameter("vln_lg_veiculoEstado", 1);
        query.setParameter("vln_nr_classificacaoVeiculo", 0);
        query.setParameter("vln_nr_codigoInfracao", 1);
        query.setParameter("vln_nr_codigoLocal", 1);
        query.setParameter("vln_nr_dataHoraInfracao", "2015-09-28 08:01:02");
        query.setParameter("vln_nr_distanciaFaixaRetencao", 2);
        query.setParameter("vln_nr_distanciaRegistrada", 1);
        query.setParameter("vln_nr_faixa", 1);
        query.setParameter("vln_nr_gravaTarja",1);
        query.setParameter("vln_nr_latitude", 542.134);
        query.setParameter("vln_nr_longitude", 784.44);
        query.setParameter("vln_nr_numeroLinhasTarja", 3);
        query.setParameter("vln_nr_numeroSequencialInfracao", 1);
        query.setParameter("vln_nr_numeroSequencialVeiculo",1);
        query.setParameter("vln_nr_numeroSequencialVeiculoInfrator",1);
        query.setParameter("vln_nr_porteVeiculo", 0);
        query.setParameter("vln_nr_posicaoTarja", 1);
        query.setParameter("vln_nr_sentidoVeiculo", 1);
        query.setParameter("vln_nr_tamanhoVeiculo", 45.00);
        query.setParameter("vln_nr_tempoPerdaoParada", 0);
        query.setParameter("vln_nr_tempoPerdaoSemaforo", 0);
        query.setParameter("vln_nr_tipoEquipamento", 1);
        query.setParameter("vln_nr_tipoImagem",1);
        query.setParameter("vln_nr_velocidadeConsiderada", 62);
        query.setParameter("vln_nr_velocidadePermitida", 60);
        query.setParameter("vln_nr_velocidadeRegistrada", 69);
        query.setParameter("vln_nr_velocidadeTolerada", 60); 
        query.setParameter("vln_nr_versao", 28);
        vln_resultado = query.executeUpdate();

        query.setParameter("vlc_id_hashInfracao", "2");
        query.setParameter("vlc_dc_numeroAit", "222222222");
        query.setParameter("vlc_dc_placaVeiculo", "FCG4105");
        query.setParameter("vlc_dataJuliana", "999999");
        query.setParameter("vlc_dc_matriculaAgente", "000000");
        query.setParameter("vlc_dc_serieEquipamento", " ");
        query.setParameter("vlc_dc_urlInfracao", "www.engebras.com.br");
        query.setParameter("vlc_dh_recebimento", "");
        query.setParameter("vlc_dh_tranferencia","");
        query.setParameter("vlc_dt_dataInfracaoUTC", "2015-09-28 09:15:03");
        query.setParameter("vlc_dt_dataInfracao", "2015-09-28");
        query.setParameter("vln_fk_enquadramento", 74550); 
        query.setParameter("vln_fk_processo", 2);
        query.setParameter("vln_fk_status", 1);
        query.setParameter("vln_fk_tipoInconsistencia", 0);
        query.setParameter("vlc_hr_horaInfracao", "09:15:03");
        query.setParameter("vlc_hr_horaInfracaoUTC", "09:15:03");
        query.setParameter("vln_lg_veiculoEstado", 1);
        query.setParameter("vln_nr_classificacaoVeiculo", 0);
        query.setParameter("vln_nr_codigoInfracao", 1);
        query.setParameter("vln_nr_codigoLocal", 2);
        query.setParameter("vln_nr_dataHoraInfracao", "2015-09-28 09:15:03");
        query.setParameter("vln_nr_distanciaFaixaRetencao", 2);
        query.setParameter("vln_nr_distanciaRegistrada", 1);
        query.setParameter("vln_nr_faixa", 1);
        query.setParameter("vln_nr_gravaTarja",1);
        query.setParameter("vln_nr_latitude", 542.134);
        query.setParameter("vln_nr_longitude", 784.44);
        query.setParameter("vln_nr_numeroLinhasTarja", 3);
        query.setParameter("vln_nr_numeroSequencialInfracao", 1);
        query.setParameter("vln_nr_numeroSequencialVeiculo",1);
        query.setParameter("vln_nr_numeroSequencialVeiculoInfrator",1);
        query.setParameter("vln_nr_porteVeiculo", 0);
        query.setParameter("vln_nr_posicaoTarja", 1);
        query.setParameter("vln_nr_sentidoVeiculo", 1);
        query.setParameter("vln_nr_tamanhoVeiculo", 45.00);
        query.setParameter("vln_nr_tempoPerdaoParada", 0);
        query.setParameter("vln_nr_tempoPerdaoSemaforo", 0);
        query.setParameter("vln_nr_tipoEquipamento", 1);
        query.setParameter("vln_nr_tipoImagem",1);
        query.setParameter("vln_nr_velocidadeConsiderada", 62);
        query.setParameter("vln_nr_velocidadePermitida", 60);
        query.setParameter("vln_nr_velocidadeRegistrada", 69);
        query.setParameter("vln_nr_velocidadeTolerada", 60); 
        query.setParameter("vln_nr_versao", 28);
        vln_resultado = query.executeUpdate();
        
        query.setParameter("vlc_id_hashInfracao", "3");
        query.setParameter("vlc_dc_numeroAit", "333333333");
        query.setParameter("vlc_dc_placaVeiculo", "AAA0005");
        query.setParameter("vlc_dataJuliana", "999999");
        query.setParameter("vlc_dc_matriculaAgente", "000000");
        query.setParameter("vlc_dc_serieEquipamento", " ");
        query.setParameter("vlc_dc_urlInfracao", "www.engebras.com.br");
        query.setParameter("vlc_dh_recebimento", "");
        query.setParameter("vlc_dh_tranferencia","");
        query.setParameter("vlc_dt_dataInfracaoUTC", "2015-09-28 10:35:45");
        query.setParameter("vlc_dt_dataInfracao", "2015-09-28");
        query.setParameter("vln_fk_enquadramento", 74550); 
        query.setParameter("vln_fk_processo", 2);
        query.setParameter("vln_fk_status", 1);
        query.setParameter("vln_fk_tipoInconsistencia", 0);
        query.setParameter("vlc_hr_horaInfracao", "10:35:45");
        query.setParameter("vlc_hr_horaInfracaoUTC", "10:35:45");
        query.setParameter("vln_lg_veiculoEstado", 1);
        query.setParameter("vln_nr_classificacaoVeiculo", 0);
        query.setParameter("vln_nr_codigoInfracao", 1);
        query.setParameter("vln_nr_codigoLocal", 3);
        query.setParameter("vln_nr_dataHoraInfracao", "2015-09-28 10:35:45");
        query.setParameter("vln_nr_distanciaFaixaRetencao", 2);
        query.setParameter("vln_nr_distanciaRegistrada", 1);
        query.setParameter("vln_nr_faixa", 1);
        query.setParameter("vln_nr_gravaTarja",1);
        query.setParameter("vln_nr_latitude", 542.134);
        query.setParameter("vln_nr_longitude", 784.44);
        query.setParameter("vln_nr_numeroLinhasTarja", 3);
        query.setParameter("vln_nr_numeroSequencialInfracao", 1);
        query.setParameter("vln_nr_numeroSequencialVeiculo",1);
        query.setParameter("vln_nr_numeroSequencialVeiculoInfrator",1);
        query.setParameter("vln_nr_porteVeiculo", 0);
        query.setParameter("vln_nr_posicaoTarja", 1);
        query.setParameter("vln_nr_sentidoVeiculo", 1);
        query.setParameter("vln_nr_tamanhoVeiculo", 45.00);
        query.setParameter("vln_nr_tempoPerdaoParada", 0);
        query.setParameter("vln_nr_tempoPerdaoSemaforo", 0);
        query.setParameter("vln_nr_tipoEquipamento", 1);
        query.setParameter("vln_nr_tipoImagem",1);
        query.setParameter("vln_nr_velocidadeConsiderada", 62);
        query.setParameter("vln_nr_velocidadePermitida", 60);
        query.setParameter("vln_nr_velocidadeRegistrada", 69);
        query.setParameter("vln_nr_velocidadeTolerada", 60); 
        query.setParameter("vln_nr_versao", 28);
        vln_resultado = query.executeUpdate();
        
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registros inseridos na tabela infracao com sucesso...",""));
    }
}
