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
@Table(name = "contactenos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contactenos.findAll", query = "SELECT c FROM Contactenos c"),
    @NamedQuery(name = "Contactenos.findByIdcontactenos", query = "SELECT c FROM Contactenos c WHERE c.idcontactenos = :idcontactenos"),
    @NamedQuery(name = "Contactenos.findByAsunto", query = "SELECT c FROM Contactenos c WHERE c.asunto = :asunto"),
    @NamedQuery(name = "Contactenos.findByMensaje", query = "SELECT c FROM Contactenos c WHERE c.mensaje = :mensaje")})
public class Contactenos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontactenos")
    private Integer idcontactenos;
    @Size(max = 2147483647)
    @Column(name = "asunto")
    private String asunto;
    @Size(max = 2147483647)
    @Column(name = "mensaje")
    private String mensaje;
    @JoinColumn(name = "idusuario", referencedColumnName = "cedula")
    @ManyToOne
    private Usuario idusuario;

    public Contactenos() {
    }

    public Contactenos(Integer idcontactenos) {
        this.idcontactenos = idcontactenos;
    }

    public Integer getIdcontactenos() {
        return idcontactenos;
    }

    public void setIdcontactenos(Integer idcontactenos) {
        this.idcontactenos = idcontactenos;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontactenos != null ? idcontactenos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contactenos)) {
            return false;
        }
        Contactenos other = (Contactenos) object;
        if ((this.idcontactenos == null && other.idcontactenos != null) || (this.idcontactenos != null && !this.idcontactenos.equals(other.idcontactenos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Contactenos[ idcontactenos=" + idcontactenos + " ]";
    }
    
}
