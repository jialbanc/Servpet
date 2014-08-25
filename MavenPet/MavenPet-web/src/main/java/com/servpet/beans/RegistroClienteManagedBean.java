/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet.beans;

import Entities.Rol;
import Entities.Usuario;
import static com.servpet.enums.Rol.*;
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

@ManagedBean(name = "registroClienteManagedBean", eager = true)
@RequestScoped
public class RegistroClienteManagedBean {

    /**
     * Creates a new instance of RegistroClienteManagedBean
     */
    @EJB
    private Facades.RolFacadeLocal role;
    @EJB 
    private Facades.UsuarioFacadeLocal usuario;
    
    private Entities.Rol rolcliente;
    private String nombre;
    private String apellido;
    private String cedula;
    private String password;
    private String email;
    private String direccion;

     @PostConstruct
    public void init(){
        for(Rol r : role.findAll()){
            if(r.getRol().equals(CLIENT.getReference()))
                rolcliente = r;
          
        }
    }

    public Rol getRolcliente() {
        return rolcliente;
    }

    public void setRolcliente(Rol rolcliente) {
        this.rolcliente = rolcliente;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public RegistroClienteManagedBean() {
    }
    
    public void registroCliente(){
        password=(String.valueOf(apellido.hashCode()));     
        System.out.println(apellido+":"+cedula+":"+direccion+":"+email+":");
        usuario.create(new Usuario(cedula, nombre, apellido, email, password, direccion, role.getRolByIdRol(rolcliente.getIdrol())));
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Registro Exitoso", "De: "+apellido ) );
        setApellido("");
        setCedula("");
        setDireccion("");
        setEmail("");
        setNombre("");
        setPassword("");
    }
}
