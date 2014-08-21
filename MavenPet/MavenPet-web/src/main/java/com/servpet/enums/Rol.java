/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet.enums;

/**
 *
 * @author Jimmy
 */
public enum Rol {
    
    ADMIN("ROLE_ADMIN","admin"),
    DOCTOR("ROLE_DOCTOR","doctor"),
    EMPLOYEE("ROLE_EMPLOYEE","employee"),
    CLIENT("ROLE_CLIENT","client");
    
    private final String reference;
    private final String tag;
    
    Rol(String ref, String tag){
        this.reference=ref;
        this.tag=tag;
    }
    
    public String getTag() {
        return tag;
    }

    public String getReference() {
        return reference;
    }
    
    
}
