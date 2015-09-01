
package br.com.samtweb.model.entities;

/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 01/09/2015
 */

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@Entity
@Table(name="infracao")
public class infracao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_hashInfracao", nullable=false, length=64) 
    private String id_hashInfracao;
    @Column(name="nr_codigoLocal", nullable=false, length=4)
    private int nr_codigoLocal;
    @Column(name="nr_longitude", nullable=false, length=11)
    private Double nr_longitude;
    @Column(name="nr_latitude", nullable=false, length=11)
    private Double nr_latitude;
    @Column(name="nr_faixa", nullable=false, length=1)
    private int nr_faixa; 
    @Column(name="dc_serieEquipameto", nullable=false, length=16)
    private String dc_serieEquipameto;
    @Column(name="dataJuliana", nullable=false, length=8)
    private int dataJuliana;
    @Column(name="dt_dataInfracao", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date dt_dataInfracao;
}
