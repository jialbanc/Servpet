/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet.beans;

import Entities.Citas;
import Entities.Mascotas;
import Entities.Usuario;
import Entities.UsuarioHasCitas;
import Facades.CitasFacadeLocal;
import Facades.MascotasFacade;
import Facades.MascotasFacadeLocal;
import Facades.UsuarioFacade;
import Facades.UsuarioFacadeLocal;
import Facades.UsuarioHasCitasFacadeLocal;
import static com.servpet.enums.Status.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "historialManagedBean", eager = true)
@ViewScoped
public class HistorialManagedBean {

    /**
     * Creates a new instance of HistorialManagedBean
    */
    
    @EJB
    private Facades.CitasFacadeLocal citas;
    private List<Entities.Citas> ltCitas;
    private Entities.Citas SelectCitas;
    private List<Entities.Citas> CitasConcluidas;
   
    @EJB
     private Facades.MascotasFacadeLocal mascotas;
    private List<Entities.Mascotas> ltMascotas;
    
    @EJB
    private Facades.UsuarioHasCitasFacadeLocal usuarioCitas;
    private List<Entities.UsuarioHasCitas> ltusuarioCitas;
    
    @EJB
    private Facades.UsuarioFacadeLocal usuario;
    private Mascotas selectedMascotas; 
    
    private List<Entities.Usuario> usuariosfiltrados;
    
    @PostConstruct
    public void init(){
        CitasConcluidas = new ArrayList<Entities.Citas>() {};
        ltCitas=citas.findAll();
        for (Citas r : ltCitas){
            if(r.getEstado().equals(CONCLUDED.getReference())){
                CitasConcluidas.add(r);
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
    
    

    public UsuarioHasCitasFacadeLocal getUsuarioCitas() {
        return usuarioCitas;
    }

    public void setUsuarioCitas(UsuarioHasCitasFacadeLocal usuarioCitas) {
        this.usuarioCitas = usuarioCitas;
    }

    public List<UsuarioHasCitas> getLtusuarioCitas() {
        return ltusuarioCitas;
    }

    public void setLtusuarioCitas(List<UsuarioHasCitas> ltusuarioCitas) {
        this.ltusuarioCitas = ltusuarioCitas;
    }

    public Citas getSelectCitas() {
        return SelectCitas;
    }

    public void setSelectCitas(Citas SelectCitas) {
        this.SelectCitas = SelectCitas;
    }

    public List<Citas> getCitasConcluidas() {
        return CitasConcluidas;
    }

    public void setCitasConcluidas(List<Citas> CitasConcluidas) {
        this.CitasConcluidas = CitasConcluidas;
    }
     

    public HistorialManagedBean() {
       
       
    }


}
   