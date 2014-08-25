/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet.beans;

import Entities.Contactenos;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


/**
 *
 * @author gianella
 */

@ManagedBean(name = "contactenosClienteManagedBean", eager = true)
@RequestScoped
public class ContactenosClienteManagedBean {

    /**
     * Creates a new instance of ContactenosClienteManagedBean
     */
    int i=0;
  @EJB
  private Facades.ContactenosFacadeLocal contacte;
  @EJB 
  private Facades.UsuarioFacadeLocal usuarioFacade;
  private UserManagedBean usuario;
    private String asunto;
    private String mensaje;
    private String id;
    public ContactenosClienteManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        id= FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
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
    /*Guardar mensjes de contactos*/
    public void contact(){
        
        System.out.println("Guardado el mensaje con el sig:"+asunto+":"+mensaje+ FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
        //usu = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
       contacte.create(new Contactenos(usuarioFacade.getUsuarioById( FacesContext.getCurrentInstance().getExternalContext().getRemoteUser()),asunto,mensaje));
       FacesContext context = FacesContext.getCurrentInstance();
       context.addMessage(null, new FacesMessage("Envio Exitoso", "De: " ) );
       setAsunto("");
       setMensaje("");
      
    }
}
