/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gianella
 */
@Entity
@Table(name = "citas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c"),
    @NamedQuery(name = "Citas.findByIdcitas", query = "SELECT c FROM Citas c WHERE c.idcitas = :idcitas"),
    @NamedQuery(name = "Citas.findByFecha", query = "SELECT c FROM Citas c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Citas.findByHora", query = "SELECT c FROM Citas c WHERE c.hora = :hora"),
    @NamedQuery(name = "Citas.findByHoraFecha", query = "SELECT c FROM Citas c WHERE c.hora = :hora AND c.fecha = :fecha"),
    @NamedQuery(name = "Citas.findByEstado", query = "SELECT c FROM Citas c WHERE c.estado = :estado"),
    @NamedQuery(name = "Citas.findByMedicina", query = "SELECT c FROM Citas c WHERE c.medicina = :medicina"),
    @NamedQuery(name = "Citas.findByDiagnostico", query = "SELECT c FROM Citas c WHERE c.diagnostico = :diagnostico"),
    @NamedQuery(name = "Citas.findByObservaciones", query = "SELECT c FROM Citas c WHERE c.observaciones = :observaciones")})
public class Citas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcitas")
    private Integer idcitas;
    @Size(max = 2147483647)
    @Column(name = "fecha")
    private String fecha;
    @Size(max = 2147483647)
    @Column(name = "hora")
    private String hora;
    @Size(max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Size(max = 2147483647)
    @Column(name = "medicina")
    private String medicina;
    @Size(max = 2147483647)
    @Column(name = "diagnostico")
    private String diagnostico;
    @Size(max = 2147483647)
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(mappedBy = "idcitas")
    private List<UsuarioHasCitas> usuarioHasCitasList;
    @OneToMany(mappedBy = "idcitas")
    private List<DetalleCita> detalleCitaList;
    @OneToMany(mappedBy = "idcitas")
    private List<Notificaciones> notificacionesList;
    @JoinColumn(name = "idmascota", referencedColumnName = "idmascotas")
    @ManyToOne
    private Mascotas idmascota;

    public Citas() {
    }

    public Citas(Integer idcitas) {
        this.idcitas = idcitas;
    }

    public Citas(String fecha, String hora, String estado) {
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public Integer getIdcitas() {
        return idcitas;
    }

    public void setIdcitas(Integer idcitas) {
        this.idcitas = idcitas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMedicina() {
        return medicina;
    }

    public void setMedicina(String medicina) {
        this.medicina = medicina;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<UsuarioHasCitas> getUsuarioHasCitasList() {
        return usuarioHasCitasList;
    }

    public void setUsuarioHasCitasList(List<UsuarioHasCitas> usuarioHasCitasList) {
        this.usuarioHasCitasList = usuarioHasCitasList;
    }

    @XmlTransient
    public List<DetalleCita> getDetalleCitaList() {
        return detalleCitaList;
    }

    public void setDetalleCitaList(List<DetalleCita> detalleCitaList) {
        this.detalleCitaList = detalleCitaList;
    }

    @XmlTransient
    public List<Notificaciones> getNotificacionesList() {
        return notificacionesList;
    }

    public void setNotificacionesList(List<Notificaciones> notificacionesList) {
        this.notificacionesList = notificacionesList;
    }

    public Mascotas getIdmascota() {
        return idmascota;
    }

    public void setIdmascota(Mascotas idmascota) {
        this.idmascota = idmascota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcitas != null ? idcitas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.idcitas == null && other.idcitas != null) || (this.idcitas != null && !this.idcitas.equals(other.idcitas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Citas[ idcitas=" + idcitas + " ]";
    }
    
}
