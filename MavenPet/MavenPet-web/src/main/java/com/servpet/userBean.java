/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Jimmy
 */
@Named(value = "userBean")
@SessionScoped
public class userBean implements Serializable {
    
    private String name,password;

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

    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Creates a new instance of userBean
     */
    
    
    public userBean() {
    }
    
}
