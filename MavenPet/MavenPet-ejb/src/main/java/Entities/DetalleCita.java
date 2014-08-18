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
import javax.validation.constraints.Size;
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
    @NamedQuery(name = "DetalleCita.findByIddetalleCita", query = "SELECT d FROM DetalleCita d WHERE d.iddetalleCita = :iddetalleCita"),
    @NamedQuery(name = "DetalleCita.findByIdcitas", query = "SELECT d FROM DetalleCita d WHERE d.idcitas = :idcitas")})
public class DetalleCita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "iddetalle_cita")
    private String iddetalleCita;
    @Size(max = 2147483647)
    @Column(name = "idcitas")
    private String idcitas;
    @JoinColumn(name = "idservicios", referencedColumnName = "idservicio")
    @ManyToOne
    private Servicios idservicios;

    public DetalleCita() {
    }

    public DetalleCita(String iddetalleCita) {
        this.iddetalleCita = iddetalleCita;
    }

    public String getIddetalleCita() {
        return iddetalleCita;
    }

    public void setIddetalleCita(String iddetalleCita) {
        this.iddetalleCita = iddetalleCita;
    }

    public String getIdcitas() {
        return idcitas;
    }

    public void setIdcitas(String idcitas) {
        this.idcitas = idcitas;
    }

    public Servicios getIdservicios() {
        return idservicios;
    }

    public void setIdservicios(Servicios idservicios) {
        this.idservicios = idservicios;
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
