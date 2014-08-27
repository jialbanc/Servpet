/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet.beans;

import Entities.Citas;
import Entities.Notificaciones;
import Entities.Rol;
import Entities.Usuario;
import Entities.UsuarioHasCitas;
import Facades.CitasFacadeLocal;
import static com.servpet.enums.Rol.CLIENT;
import static com.servpet.enums.Rol.EMPLOYEE;
import static com.servpet.enums.Status.CONCLUDED;
import java.util.ArrayList;
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
    private List<Entities.Citas> CitasConcluidas;
    
    
    @EJB
    private Facades.NotificacionesFacadeLocal notificaciones;
    private List<Entities.Notificaciones> ltNotificaciones;
    private Entities.Notificaciones SelectNotificaciones;
    
    @EJB
    private Facades.RolFacadeLocal role;
    
    private List<Entities.Usuario> usuariosfiltrados;
     private Entities.Rol rolEmpleado;
    
    
    public NotificacionesManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        CitasConcluidas = new ArrayList<Entities.Citas>() {};
        ltCitas=citas.findAll();
        ltNotificaciones=notificaciones.findAll();
        
            for(Rol s : role.findAll()){
                 if(s.getRol().equals(EMPLOYEE.getReference())){
                   rolEmpleado = s; 
                 }   
            }
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

    public List<Citas> getCitasConcluidas() {
        return CitasConcluidas;
    }

    public void setCitasConcluidas(List<Citas> CitasConcluidas) {
        this.CitasConcluidas = CitasConcluidas;
    }

    public List<Notificaciones> getLtNotificaciones() {
        return ltNotificaciones;
    }

    public void setLtNotificaciones(List<Notificaciones> ltNotificaciones) {
        this.ltNotificaciones = ltNotificaciones;
    }

    public Rol getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(Rol rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public Notificaciones getSelectNotificaciones() {
        return SelectNotificaciones;
    }

    public void setSelectNotificaciones(Notificaciones SelectNotificaciones) {
        this.SelectNotificaciones = SelectNotificaciones;
    }
    
    
    
}
