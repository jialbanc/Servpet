/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet.beans;

import com.servpet.enums.Rol;
import static com.servpet.enums.Rol.*;
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
        if(isThisUser(currentUser, ADMIN))
            currentUserRol=ADMIN.getTag();
        if(isThisUser(currentUser, CLIENT))
            currentUserRol=CLIENT.getTag();
        if(isThisUser(currentUser, EMPLOYEE))
            currentUserRol=EMPLOYEE.getTag();
        if(isThisUser(currentUser, DOCTOR))
            currentUserRol=DOCTOR.getTag();
    }
    
    private boolean isThisUser(String user, Rol r){
        boolean state=false;
        if(usuarioFacade.getUsuarioById(user).getIdrol().getRol().equals(r.getReference()))
            state=true;
        return state;
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
    public boolean userRolIs(Rol r){
        boolean state=false;
        if(currentUserRol.equals(r.getTag()))
            state=true;
        return state;
    }
    public boolean contactenosIsRendering(){
        boolean state=false;
        if(userRolIs(ADMIN))
            state=true;
        if(userRolIs(CLIENT))
            state=true;
        return state;
    }
    
    public boolean historialIsRendering(){
        boolean state=false;
        if(userRolIs(ADMIN))
            state=true;
        if(userRolIs(DOCTOR))
            state=true;
        if(userRolIs(EMPLOYEE))
            state=true;
        return state;
    }
    
    public boolean notificacionesIsRendering(){
        boolean state=false;
        if(userRolIs(ADMIN))
            state=true;
        if(userRolIs(CLIENT))
            state=true;
        if(userRolIs(EMPLOYEE))
            state=true;
        return state;
    }
    
}
