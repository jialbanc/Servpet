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
import static com.servpet.enums.Rol.*;
import static com.servpet.enums.Status.CONCLUDED;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author usuario
 */
@ManagedBean(name = "notificacionesManagedBean", eager = true)
@ViewScoped
public class NotificacionesManagedBean {

    
    @EJB
    private Facades.CitasFacadeLocal citas;
    private List<Entities.Citas> ltCitas;
    private List<Entities.Citas> CitasConcluidas;
    
    
    @EJB
    private Facades.NotificacionesFacadeLocal notificaciones;
    private List<Entities.Notificaciones> ltNotificaciones;
    private Entities.Usuario userSelected;
    private Entities.Citas citaSelected;
    
    @EJB
    private Facades.RolFacadeLocal role;
    
    private List<Entities.Usuario> usuariosfiltrados;
    private List<Entities.Usuario> ltEmpleados;
    private List<Entities.Citas> ltCitasEmpleado;
    private List<Entities.Rol> ltroles;
    
    
    public NotificacionesManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        ltroles= role.findAll();
        for (Rol r : ltroles){
            if(r.getRol().equals(EMPLOYEE.getReference()))
                ltEmpleados = r.getUsuarioList();
        }
        
    }

    public List<Usuario> getLtEmpleados() {
        return ltEmpleados;
    }

    public void setLtEmpleados(List<Usuario> ltEmpleados) {
        this.ltEmpleados = ltEmpleados;
    }

    public Usuario getUserSelected() {
        return userSelected;
    }

    public void setUserSelected(Usuario userSelected) {
        ltCitasEmpleado = new ArrayList<Entities.Citas>();
        for(UsuarioHasCitas u : userSelected.getUsuarioHasCitasList()){
            if(u.getIdcitas().getEstado().equals(CONCLUDED.getReference()))
                ltCitasEmpleado.add(u.getIdcitas());
        }
        this.userSelected = userSelected;
    }

    public List<Citas> getLtCitasEmpleado() {
        return ltCitasEmpleado;
    }

    public void setLtCitasEmpleado(List<Citas> ltCitasEmpleado) {
        this.ltCitasEmpleado = ltCitasEmpleado;
    }

    public List<Rol> getLtroles() {
        return ltroles;
    }

    public void setLtroles(List<Rol> ltroles) {
        this.ltroles = ltroles;
    }

    public Citas getCitaSelected() {
        return citaSelected;
    }

    public void setCitaSelected(Citas citaSelected) {
        ltNotificaciones = citaSelected.getNotificacionesList();
        this.citaSelected = citaSelected;
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

}
