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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name = "DetalleCita.findByIddetalleCitas", query = "SELECT d FROM DetalleCita d WHERE d.iddetalleCitas = :iddetalleCitas")})
public class DetalleCita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetalle_citas")
    private Integer iddetalleCitas;
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicio")
    @ManyToOne
    private Servicios idservicio;
    @JoinColumn(name = "idcitas", referencedColumnName = "idcitas")
    @ManyToOne
    private Citas idcitas;

    public DetalleCita() {
    }

    public DetalleCita(Integer iddetalleCitas) {
        this.iddetalleCitas = iddetalleCitas;
    }

    public Integer getIddetalleCitas() {
        return iddetalleCitas;
    }

    public void setIddetalleCitas(Integer iddetalleCitas) {
        this.iddetalleCitas = iddetalleCitas;
    }

    public Servicios getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Servicios idservicio) {
        this.idservicio = idservicio;
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
        hash += (iddetalleCitas != null ? iddetalleCitas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCita)) {
            return false;
        }
        DetalleCita other = (DetalleCita) object;
        if ((this.iddetalleCitas == null && other.iddetalleCitas != null) || (this.iddetalleCitas != null && !this.iddetalleCitas.equals(other.iddetalleCitas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.DetalleCita[ iddetalleCitas=" + iddetalleCitas + " ]";
    }
    
}
