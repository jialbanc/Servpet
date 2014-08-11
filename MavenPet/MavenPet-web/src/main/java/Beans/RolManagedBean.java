/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import Entities.Rol;
import Facades.RolFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jimmy
 */
@ManagedBean(name = "rolManagedBean", eager = true)
@ViewScoped
public class RolManagedBean {
    @EJB
    private Facades.RolFacadeLocal rolFacade;    
    private List<Entities.Rol> ltRols ;
    private String currentUser;
    private String currentUserRol;
    /**
     * Creates a new instance of RolManagedBean
     */
    public RolManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        ltRols = rolFacade.findAll();
        currentUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        if(rolFacade.getRolByUser(currentUser).equals("ROLE_ADMIN"))
            currentUserRol="admin";
        if(rolFacade.getRolByUser(currentUser).equals("ROLE_CLIENT"))
            currentUserRol="client";
        if(rolFacade.getRolByUser(currentUser).equals("ROLE_EMPLOYEE"))
            currentUserRol="employee";
        if(rolFacade.getRolByUser(currentUser).equals("ROLE_DOCTOR"))
            currentUserRol="doctor";
    }

    public RolFacadeLocal getRolFacade() {
        return rolFacade;
    }

    public void setRolFacade(RolFacadeLocal rolFacade) {
        this.rolFacade = rolFacade;
    }

    public List<Rol> getLtRols() {
        return ltRols;
    }

    public void setLtRols(List<Rol> ltRols) {
        this.ltRols = ltRols;
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
