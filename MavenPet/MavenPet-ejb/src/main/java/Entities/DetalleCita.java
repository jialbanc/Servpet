/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jimmy
 */
@Entity
@Table(name = "detalle_cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCita.findAll", query = "SELECT d FROM DetalleCita d"),
    @NamedQuery(name = "DetalleCita.findByIddetalleCita", query = "SELECT d FROM DetalleCita d WHERE d.iddetalleCita = :iddetalleCita")})
public class DetalleCita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddetalle_cita")
    private Integer iddetalleCita;
    @JoinColumn(name = "idservicios", referencedColumnName = "idservicio")
    @ManyToOne
    private Servicios idservicios;
    @JoinColumn(name = "idcitas", referencedColumnName = "idcitas")
    @ManyToOne
    private Citas idcitas;

    public DetalleCita() {
    }

    public DetalleCita(Integer iddetalleCita) {
        this.iddetalleCita = iddetalleCita;
    }

    public Integer getIddetalleCita() {
        return iddetalleCita;
    }

    public void setIddetalleCita(Integer iddetalleCita) {
        this.iddetalleCita = iddetalleCita;
    }

    public Servicios getIdservicios() {
        return idservicios;
    }

    public void setIdservicios(Servicios idservicios) {
        this.idservicios = idservicios;
    }

    public Citas getIdcitas() {
        return idcitas;
    }

    public void setIdcitas(Citas idcitas) {
        this.idcitas = idcitas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleCita != null ? iddetalleCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCita)) {
            return false;
        }
        DetalleCita other = (DetalleCita) object;
        if ((this.iddetalleCita == null && other.iddetalleCita != null) || (this.iddetalleCita != null && !this.iddetalleCita.equals(other.iddetalleCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.DetalleCita[ iddetalleCita=" + iddetalleCita + " ]";
    }
    
}
