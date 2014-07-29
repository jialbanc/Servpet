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
@Table(name = "usuario_has_citas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioHasCitas.findAll", query = "SELECT u FROM UsuarioHasCitas u"),
    @NamedQuery(name = "UsuarioHasCitas.findByIdusuarioCitas", query = "SELECT u FROM UsuarioHasCitas u WHERE u.idusuarioCitas = :idusuarioCitas")})
public class UsuarioHasCitas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "idusuario_citas")
    private String idusuarioCitas;
    @JoinColumn(name = "idusuario", referencedColumnName = "cedula")
    @ManyToOne
    private Usuario idusuario;
    @JoinColumn(name = "idcitas", referencedColumnName = "idcitas")
    @ManyToOne
    private Citas idcitas;

    public UsuarioHasCitas() {
    }

    public UsuarioHasCitas(String idusuarioCitas) {
        this.idusuarioCitas = idusuarioCitas;
    }

    public String getIdusuarioCitas() {
        return idusuarioCitas;
    }

    public void setIdusuarioCitas(String idusuarioCitas) {
        this.idusuarioCitas = idusuarioCitas;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
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
        hash += (idusuarioCitas != null ? idusuarioCitas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasCitas)) {
            return false;
        }
        UsuarioHasCitas other = (UsuarioHasCitas) object;
        if ((this.idusuarioCitas == null && other.idusuarioCitas != null) || (this.idusuarioCitas != null && !this.idusuarioCitas.equals(other.idusuarioCitas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.UsuarioHasCitas[ idusuarioCitas=" + idusuarioCitas + " ]";
    }
    
}
