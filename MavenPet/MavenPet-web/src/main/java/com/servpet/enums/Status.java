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
public enum Status {
    AVAILABLE("disponible"),
    RESERVED("reservado"),
    CANCELED("cancelado"),
    CONCLUDED("concluido");
    
    private final String reference;
    
    Status(String ref){
        this.reference = ref;
    }

    public String getReference() {
        return reference;
    }
}
