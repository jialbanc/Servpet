/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name = "userManagedBean", eager = true)
@ViewScoped
public class UserManagedBean {
    @EJB
    private Facades.UsuarioFacadeLocal usuarioFacade;
    private String currentUser;
    private String currentUserRol;
    /**
     * Creates a new instance of UserManagedBean
     */
    public UserManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        currentUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        if(usuarioFacade.getUsuarioById(currentUser).getIdrol().getRol().equals("ROLE_ADMIN"))
            currentUserRol="admin";
        if(usuarioFacade.getUsuarioById(currentUser).getIdrol().getRol().equals("ROLE_CLIENT"))
            currentUserRol="client";
        if(usuarioFacade.getUsuarioById(currentUser).getIdrol().getRol().equals("ROLE_EMPLOYEE"))
            currentUserRol="employee";
        if(usuarioFacade.getUsuarioById(currentUser).getIdrol().getRol().equals("ROLE_DOCTOR"))
            currentUserRol="doctor";
    }
    
    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public String getCurrentUserRol() {
        return currentUserRol;
    }

    public void setCurrentUserRol(String currentUserRol) {
        this.currentUserRol = currentUserRol;
    }
    
    public boolean contactenosIsRendering(){
        boolean state=false;
        if(currentUserRol.equals("admin"))
            state=true;
        if(currentUserRol.equals("client"))
            state=true;
        return state;
    }
    
    public boolean historialIsRendering(){
        boolean state=false;
        if(currentUserRol.equals("admin"))
            state=true;
        if(currentUserRol.equals("doctor"))
            state=true;
        if(currentUserRol.equals("employee"))
            state=true;
        return state;
    }
    
    public boolean notificacionesIsRendering(){
        boolean state=false;
        if(currentUserRol.equals("admin"))
            state=true;
        if(currentUserRol.equals("client"))
            state=true;
        if(currentUserRol.equals("employee"))
            state=true;
        return state;
    }
    
}
