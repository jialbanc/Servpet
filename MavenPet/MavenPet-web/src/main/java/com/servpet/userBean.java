/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 * @author Jimmy
 */
@Named(value = "userBean")
@ViewScoped
public class userBean {
    
    private String name,password,rol;

    /**
     * Creates a new instance of userBean
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }
    
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    @PostConstruct
    public void init(){
        rol="admin";
        name = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        System.out.println(name);
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Creates a new instance of userBean
     */
    
    public userBean() {
    }
    
}
