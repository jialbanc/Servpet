/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet.beans;

import Entities.Mascotas;
import Entities.Usuario;
import Facades.MascotasFacade;
import Facades.MascotasFacadeLocal;
import Facades.UsuarioFacade;
import Facades.UsuarioFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "historialManagedBean", eager = true)
@RequestScoped
public class HistorialManagedBean {

    /**
     * Creates a new instance of HistorialManagedBean
    */
    
    @EJB
    private Facades.MascotasFacadeLocal mascotas;
    private List<Entities.Mascotas> ltmascotas;
    
    private Facades.UsuarioFacadeLocal usuario;
    
    private List<Entities.Usuario> usuariosfiltrados;
   /* public MascotasFacadeLocal getMascotas() {
        return mascotas;
    }

    public void setMascotas(MascotasFacadeLocal mascotas) {
        this.mascotas = mascotas;
    }

    public List<Mascotas> getLtmascotas() {
        return ltmascotas = mascotas.findAll();
        
    }

    public void setLtmascotas(List<Mascotas> ltmascotas) {
        this.ltmascotas = ltmascotas;
    }*/
    
    @PostConstruct
    public void init(){
        ltmascotas = mascotas.findAll();
    }

    public List<Mascotas> getLtmascotas() {
        return ltmascotas;
    }

    public void setLtmascotas(List<Mascotas> ltmascotas) {
        this.ltmascotas = ltmascotas;
    }

    public List<Usuario> getUsuariosfiltrados() {
        return usuariosfiltrados;
    }

    public void setUsuariosfiltrados(List<Usuario> usuariosfiltrados) {
        this.usuariosfiltrados = usuariosfiltrados;
    }
    
    public String getUserFromMascota(String userId){
        return usuario.getUsuarioById(userId).getApellido();
    }
 

     public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Cliente editado", ((Usuario) event.getObject()).getCedula());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Usuario) event.getObject()).getCedula());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public HistorialManagedBean() {
       
       
    }
    
    public void onCellEdit(CellEditEvent event) {
        Entities.Usuario u= new Usuario();
        u.setCedula((String) event.getNewValue());
        
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Celda cambiada", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
 
}
