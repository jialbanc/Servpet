/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet.beans;

import Entities.Rol;
import Entities.Usuario;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import static com.servpet.enums.Rol.*;


/**
 *
 * @author gianella
 */
@ManagedBean(name = "registroManagedBean", eager = true)
@RequestScoped
public class RegistroManagedBean {

    /**
     * Creates a new instance of RegistroManagedBean
     */
    @EJB
    private Facades.RolFacadeLocal rolFacade;
    @EJB
    private Facades.UsuarioFacadeLocal usuario;
    
    private Entities.Rol rolDoctor;
    private Entities.Rol rolEmpleado;
    
    private String cedula;
    private String nombre;
    private String apellido;
    private String password;
    private String email;
    private String direccion;
    private Integer idrol;
    
    @PostConstruct
    public void init(){
        for(Rol r : rolFacade.findAll()){
            if(r.getRol().equals(DOCTOR.getReference()))
                rolDoctor = r;
            if(r.getRol().equals(EMPLOYEE.getReference()))
                rolEmpleado = r;
        }
    }
    
    public RegistroManagedBean() {
    }

    public Rol getRolDoctor() {
        return rolDoctor;
    }

    public void setRolDoctor(Rol rolDoctor) {
        this.rolDoctor = rolDoctor;
    }

    public Rol getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(Rol rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public void nuevoE(){
       password=(String.valueOf(apellido.hashCode()));     
       System.out.println(nombre);
       System.out.println(apellido+":"+cedula+":"+direccion+":"+email+":"+idrol);
       usuario.create(new Usuario(cedula, nombre, apellido, email, password, direccion, (rolFacade.getRolByIdRol(idrol))));
       FacesContext context = FacesContext.getCurrentInstance();
       context.addMessage(null, new FacesMessage("Registro Exitoso", "De: "+apellido ) );
       setApellido("");
       setCedula("");
       setDireccion("");
       setEmail("");
       setIdrol(0);
       setPassword("");
       setNombre("");
    }
    
}
