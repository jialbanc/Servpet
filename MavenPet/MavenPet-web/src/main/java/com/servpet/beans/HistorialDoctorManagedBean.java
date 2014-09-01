/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servpet.beans;

import Entities.Citas;
import Entities.Rol;
import Entities.Servicios;
import Entities.Usuario;
import Entities.UsuarioHasCitas;
import Facades.UsuarioFacadeLocal;
import static com.servpet.enums.Rol.DOCTOR;
import static com.servpet.enums.Rol.EMPLOYEE;
import static com.servpet.enums.Status.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author usuario
 */
@ManagedBean(name = "historialDoctorManagedBean", eager = true)
@ViewScoped
public class HistorialDoctorManagedBean {

    /**
     * Creates a new instance of HistorialDoctorManagedBean
     */
    
    @EJB
    private Facades.CitasFacadeLocal Citas;
    private List<Entities.Citas> ltCitas;
    private List<Entities.Citas> CitasReservadas;
    
    @EJB
    private Facades.UsuarioFacadeLocal usuario;
    private List<Entities.Usuario> ltusuarios;
    private List<Entities.Citas> ltCitasCliente;
    private Entities.Usuario userSelected;
    private Entities.Citas citaSelected;
    
    @EJB
    private Facades.ServiciosFacadeLocal ServicioFacade;
    private List<Entities.Servicios> ltServicios;
    private Entities.Servicios baño;
    private Entities.Servicios vacunas;
    private Entities.Servicios despulgar;
    private Entities.Servicios cita;
    
    private String estado;
    private String servicios;
    private String medicina;
    private String observaciones;
    private String diagnostico;
    private Integer idServicios;
    
     @PostConstruct
    public void init(){
        CitasReservadas = new ArrayList<Entities.Citas>() {};
        ltCitas=Citas.findAll();
        for (Citas r : ltCitas){
            if(r.getEstado().equals(RESERVED.getReference())){
                CitasReservadas.add(r);
             }        
        }

        for(Servicios r : ServicioFacade.findAll()){
            if(r.getServicio().equals("baño"))
                baño=r;
            if(r.getServicio().equals("vacunas"))
                vacunas = r;
            if(r.getServicio().equals("despulgar"))
                despulgar = r;
            if(r.getServicio().equals("cita"))
                cita = r;
        }
    
    }

    public List<Citas> getLtCitas() {
        return ltCitas;
    }

    public void setLtCitas(List<Citas> ltCitas) {
        this.ltCitas = ltCitas;
    }

    public List<Citas> getCitasReservadas() {
        return CitasReservadas;
    }

    public void setCitasReservadas(List<Citas> CitasReservadas) {
        this.CitasReservadas = CitasReservadas;
    }

    public UsuarioFacadeLocal getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioFacadeLocal usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLtusuarios() {
        
        return ltusuarios;
    }

    public void setLtusuarios(List<Usuario> ltusuarios) {
        this.ltusuarios = ltusuarios;
    }

    public List<Citas> getLtCitasCliente() {
        return ltCitasCliente;
    }

    public void setLtCitasCliente(List<Citas> ltCitasCliente) {
        this.ltCitasCliente = ltCitasCliente;
    }

    public Usuario getUserSelected() {
        return userSelected;
    }

    public void setUserSelected(Usuario userSelected) {
        //ltCitasCliente = new ArrayList<Entities.Citas>();
        //for(UsuarioHasCitas u : userSelected.getUsuarioHasCitasList()){
          //  if(u.getIdcitas().getEstado().equals(RESERVED.getReference()))
            //    ltCitasCliente.add(u.getIdcitas());
        //}
        this.userSelected = userSelected;
    }

    public Citas getCitaSelected() {
        return citaSelected;
    }

    public void setCitaSelected(Citas citaSelected) {
        this.citaSelected = citaSelected;
    }

    public List<Servicios> getLtServicios() {
        return ltServicios;
    }

    public void setLtServicios(List<Servicios> ltServicios) {
        this.ltServicios = ltServicios;
    }

    public Servicios getBaño() {
        return baño;
    }

    public void setBaño(Servicios baño) {
        this.baño = baño;
    }

    public Servicios getVacunas() {
        return vacunas;
    }

    public void setVacunas(Servicios vacunas) {
        this.vacunas = vacunas;
    }

    public Servicios getDespulgar() {
        return despulgar;
    }

    public void setDespulgar(Servicios despulgar) {
        this.despulgar = despulgar;
    }

    public Servicios getCita() {
        return cita;
    }

    public void setCita(Servicios cita) {
        this.cita = cita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getMedicina() {
        return medicina;
    }

    public void setMedicina(String medicina) {
        this.medicina = medicina;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Integer getIdServicios() {
        return idServicios;
    }

    public void setIdServicios(Integer idServicios) {
        this.idServicios = idServicios;
    }
    
    public void nuevoHistorial(){
       //  public Citas(String estado, String medicina, String diagnostico, String observaciones          
       //Citas.edit(new Citas("concluido",medicina,diagnostico,observaciones));
        citaSelected.setEstado("concluida");
       FacesContext context = FacesContext.getCurrentInstance();
       context.addMessage(null, new FacesMessage("Historial Agregado" ) );
     
    }
    
    public HistorialDoctorManagedBean() {
    }
    
}
