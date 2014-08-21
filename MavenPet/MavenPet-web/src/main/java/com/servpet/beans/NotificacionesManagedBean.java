/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet.beans;

import Entities.Citas;
import Entities.Usuario;
import Entities.UsuarioHasCitas;
import Facades.CitasFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author usuario
 */
@ManagedBean(name = "notificacionesManagedBean", eager = true)
@RequestScoped
public class NotificacionesManagedBean {

    
    @EJB
    private Facades.CitasFacadeLocal citas;
    private List<Entities.Citas> ltCitas;
    
    private List<Entities.Usuario> usuariosfiltrados;
    
    public NotificacionesManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        ltCitas = citas.findAll();
    }

    public CitasFacadeLocal getCitas() {
        return citas;
    }

    public void setCitas(CitasFacadeLocal citas) {
        this.citas = citas;
    }

    public List<Citas> getLtCitas() {
        return ltCitas;
    }

    public void setLtCitas(List<Citas> ltCitas) {
        this.ltCitas = ltCitas;
    }

    public List<Usuario> getUsuariosfiltrados() {
        return usuariosfiltrados;
    }

    public void setUsuariosfiltrados(List<Usuario> usuariosfiltrados) {
        this.usuariosfiltrados = usuariosfiltrados;
    }
    
}
