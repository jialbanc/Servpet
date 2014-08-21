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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jimmy
 */
@Entity
@Table(name = "notificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificaciones.findAll", query = "SELECT n FROM Notificaciones n"),
    @NamedQuery(name = "Notificaciones.findByIdnotificaciones", query = "SELECT n FROM Notificaciones n WHERE n.idnotificaciones = :idnotificaciones"),
    @NamedQuery(name = "Notificaciones.findByHora", query = "SELECT n FROM Notificaciones n WHERE n.hora = :hora"),
    @NamedQuery(name = "Notificaciones.findByFecha", query = "SELECT n FROM Notificaciones n WHERE n.fecha = :fecha"),
    @NamedQuery(name = "Notificaciones.findByImagen", query = "SELECT n FROM Notificaciones n WHERE n.imagen = :imagen"),
    @NamedQuery(name = "Notificaciones.findByContenido", query = "SELECT n FROM Notificaciones n WHERE n.contenido = :contenido"),
    @NamedQuery(name = "Notificaciones.findByAsunto", query = "SELECT n FROM Notificaciones n WHERE n.asunto = :asunto")})
public class Notificaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnotificaciones")
    private Integer idnotificaciones;
    @Size(max = 2147483647)
    @Column(name = "hora")
    private String hora;
    @Size(max = 2147483647)
    @Column(name = "fecha")
    private String fecha;
    @Size(max = 2147483647)
    @Column(name = "imagen")
    private String imagen;
    @Size(max = 2147483647)
    @Column(name = "contenido")
    private String contenido;
    @Size(max = 2147483647)
    @Column(name = "asunto")
    private String asunto;
    @JoinColumn(name = "idcitas", referencedColumnName = "idcitas")
    @ManyToOne
    private Citas idcitas;

    public Notificaciones() {
    }

    public Notificaciones(Integer idnotificaciones) {
        this.idnotificaciones = idnotificaciones;
    }

    public Integer getIdnotificaciones() {
        return idnotificaciones;
    }

    public void setIdnotificaciones(Integer idnotificaciones) {
        this.idnotificaciones = idnotificaciones;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
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
        hash += (idnotificaciones != null ? idnotificaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificaciones)) {
            return false;
        }
        Notificaciones other = (Notificaciones) object;
        if ((this.idnotificaciones == null && other.idnotificaciones != null) || (this.idnotificaciones != null && !this.idnotificaciones.equals(other.idnotificaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Notificaciones[ idnotificaciones=" + idnotificaciones + " ]";
    }
    
}
